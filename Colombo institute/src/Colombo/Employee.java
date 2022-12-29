package Colombo;

public class Employee {
 private String name;
 private int epf;
 private String department;
 private String section;
 private String designation;
 
 public Employee() {
	// TODO Auto-generated constructor stub
}
 
 public Employee(String name, int epf ,String department,String section,String designation) {
	// TODO Auto-generated constructor stub
	 this.name= name;
	 this.epf= epf;
	 this.department= department;
	 this.section= section;
	 this.designation= designation;
	 
}
 
 public void setName(String name) {
	this.name = name;
}
 
 public String getName() {
	return name;
}
 
 public void setEpf(int epf) {
	this.epf = epf;
}
 
 public int getEpf() {
	return epf;
}
 
 public void setDepartment(String department) {
	this.department = department;
}
 
 public String getDepartment() {
	return department;
}
 public void setSection(String section) {
	this.section = section;
}
 public String getSection() {
	return section;
}
 
 public void setDesignation(String designation) {
	this.designation = designation;
}
 
 public String getDesignation() {
	return designation;
}
 
}
