package app.com.pojos;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name = "certificate")
public class Credendials extends BaseEntity {

	private String game;
	private String date;
	private String status;
	
	@Transient
	private String imgUtility;

	@Lob
	@Column(length = 1000000000)
	private byte[] certificate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userDetails;
	
	public Credendials() {
		super();
	}

	public Credendials(String game, String date, String status, byte[] certificate) {
		super();
		this.game = game;
		this.date = date;
		this.status = status;
		this.certificate = certificate;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImgUtility() throws UnsupportedEncodingException {

	       byte[] encodeBase64 = Base64.encodeBase64(getCertificate());
	       String base64Encoded = new String(encodeBase64, "UTF-8");              
	       return base64Encoded;
		   }

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}

	public byte[] getCertificate() {
		return certificate;
	}

	public void setCertificate(byte[] certificate) {
		this.certificate = certificate;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "Credendials [game=" + game + ", date=" + date + ", status=" + status + ", imgUtility=" + imgUtility
				+ ", certificate=" + Arrays.toString(certificate) + ", userDetails=" + userDetails + "]";
	}
	
	
}
