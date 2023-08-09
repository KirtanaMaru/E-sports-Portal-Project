package app.com.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_login")
public class User extends BaseEntity {

	private String name;

	private String email;

	private String password;

	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_address_id")
	private Addresses userAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hsc_details_id")
	private HSCDetials hscDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ssc_details_id")
	private SSCDetails sscDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "graduation_details_id")
	private GraduationDetails gDetails;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_graduation_details_id")
	private PostGraduationDetails pgDetails;

	@OneToMany
	private List<Credendials> certificateList=new ArrayList<>();
	
	public User() {
		super();
	}

	public User(String name, String email, String password, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public PostGraduationDetails getPgDetails() {
		return pgDetails;
	}

	public void setPgDetails(PostGraduationDetails pgDetails) {
		this.pgDetails = pgDetails;
	}

	public String getName() {
		return name;
	}

	public SSCDetails getSscDetails() {
		return sscDetails;
	}

	public GraduationDetails getgDetails() {
		return gDetails;
	}

	public void setgDetails(GraduationDetails gDetails) {
		this.gDetails = gDetails;
	}

	public void setSscDetails(SSCDetails sscDetails) {
		this.sscDetails = sscDetails;
	}

	public List<Credendials> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(List<Credendials> certificateList) {
		this.certificateList = certificateList;
	}

	public HSCDetials getHscDetails() {
		return hscDetails;
	}

	public void setHscDetails(HSCDetials hscDetails) {
		this.hscDetails = hscDetails;
	}

	public Addresses getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Addresses userAddress) {
		this.userAddress = userAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}

}
