package app.com.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "Acadmey_details")
public class AcadmeyDetails extends BaseEntity {


	private String name;
	
	private String location;
	
	private String established;
	
	private String sport;
	
	private String chairman;
	
	private String mobile;
	@Transient
	private String imgUtility;

	@Lob
	@Column(length = 1000000000)
	private byte[] image;
	
	@Column(length = 10000)
	private String map;

	public AcadmeyDetails() {
		super();
	}

	public AcadmeyDetails(String name, String location, String established, String sport, String chairman,
			String mobile, byte[] image, String map) {
		super();
		this.name = name;
		this.location = location;
		this.established = established;
		this.sport = sport;
		this.chairman = chairman;
		this.mobile = mobile;
		this.image = image;
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEstablished() {
		return established;
	}

	public void setEstablished(String established) {
		this.established = established;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getImage());
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "AcadmeyDetails [name=" + name + ", location=" + location + ", established=" + established + ", sport="
				+ sport + ", chairman=" + chairman + ", mobile=" + mobile + ", imgUtility=" + imgUtility + ", image="
				+ Arrays.toString(image) + ", map=" + map + "]";
	}
	
	
}
