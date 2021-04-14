package sample;

public class ModelTable {
	
	String firstname;
	String lastname;
	String group;
	String course;
	String faculty;
	
	public ModelTable(String firstname, String lastname, String group, String course, String faculty) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.group = group;
		this.course = course;
		this.faculty = faculty;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getGroup() {
		return group;
	}
	
	public String getCourse() {
		return course;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
}
