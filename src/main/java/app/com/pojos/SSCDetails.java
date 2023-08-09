package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ssc_details")
public class SSCDetails extends BaseEntity {

	private String name1;
	private String pyear1;
	private String grade1;
	public SSCDetails() {
		super();
	}
	public SSCDetails(String name, String pyear, String grade) {
		super();
		this.name1 = name;
		this.pyear1 = pyear;
		this.grade1 = grade;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPyear1() {
		return pyear1;
	}
	public void setPyear1(String pyear1) {
		this.pyear1 = pyear1;
	}
	public String getGrade1() {
		return grade1;
	}
	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}
	@Override
	public String toString() {
		return "SSCDetails [name1=" + name1 + ", pyear1=" + pyear1 + ", grade1=" + grade1 + "]";
	}
	
	
}
