package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post_graduation_details")
public class PostGraduationDetails extends BaseEntity {

	private String name3;
	private String pyear3;
	private String grade3;
	private String type2;
	public PostGraduationDetails() {
		super();
	}
	public PostGraduationDetails(String name3, String pyear3, String grade3, String type2) {
		super();
		this.name3 = name3;
		this.pyear3 = pyear3;
		this.grade3 = grade3;
		this.type2 = type2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getPyear3() {
		return pyear3;
	}
	public void setPyear3(String pyear3) {
		this.pyear3 = pyear3;
	}
	public String getGrade3() {
		return grade3;
	}
	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	@Override
	public String toString() {
		return "PostGraduationDetails [name3=" + name3 + ", pyear3=" + pyear3 + ", grade3=" + grade3 + ", type2="
				+ type2 + "]";
	}
	
}
