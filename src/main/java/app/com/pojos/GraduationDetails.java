package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "graduation_details")
public class GraduationDetails extends BaseEntity {

	private String name2;
	private String pyear2;
	private String grade2;
	private String type;
	public GraduationDetails() {
		super();
	}
	public GraduationDetails(String name2, String pyear2, String grade2, String type) {
		super();
		this.name2 = name2;
		this.pyear2 = pyear2;
		this.grade2 = grade2;
		this.type = type;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPyear2() {
		return pyear2;
	}
	public void setPyear2(String pyear2) {
		this.pyear2 = pyear2;
	}
	public String getGrade2() {
		return grade2;
	}
	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "GraduationDetails [name2=" + name2 + ", pyear2=" + pyear2 + ", grade2=" + grade2 + ", type=" + type
				+ "]";
	}
	
}
