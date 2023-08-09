package app.com.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {
	private String title;
	private String location;
	private String sport;
	private String date;
	private String price;
	private String mobile;
	@Column(length = 100000)
	private String map;

	@Transient
	private String imgUtility;

	@Lob
	@Column(length = 1000000000)
	private byte[] image;
	
	@ManyToOne
	private EventManager manager;

	public Event(String title, String location, String sport, String date, String price, String mobile, String map,
			byte[] image,EventManager manager) {
		super();
		this.manager=manager;
		this.title = title;
		this.location = location;
		this.sport = sport;
		this.date = date;
		this.price = price;
		this.mobile = mobile;
		this.map = map;
		this.image = image;
	}

	public Event() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

		byte[] encodeBase64 = Base64.encodeBase64(getImage());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	public EventManager getManager() {
		return manager;
	}

	public void setManager(EventManager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Event [title=" + title + ", location=" + location + ", sport=" + sport + ", date=" + date + ", price="
				+ price + ", mobile=" + mobile + ", map=" + map + ", imgUtility=" + imgUtility + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	

}
