package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hsc_details")
public class HSCDetials extends BaseEntity {

	private String name;
	private String pyear;
	private String grade;
	public HSCDetials() {
		super();
	}
	public HSCDetials(String name, String pyear, String grade) {
		super();
		this.name = name;
		this.pyear = pyear;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPyear() {
		return pyear;
	}
	public void setPyear(String pyear) {
		this.pyear = pyear;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "HSCDetials [name=" + name + ", pyear=" + pyear + ", grade=" + grade + "]";
	}
	
	
}
