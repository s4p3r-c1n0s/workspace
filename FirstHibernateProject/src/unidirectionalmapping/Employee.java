package unidirectionalmapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.FetchMode;

@Entity
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int empId;
	
	
@Column private String name;
@Column  private int age;


@OneToOne(cascade=CascadeType.ALL)
//@JoinColumn(name="detailid", referencedColumnName="detail_id")
@PrimaryKeyJoinColumn
private EmployeeDetail details;

/*@OneToMany(cascade=CascadeType.ALL )
@JoinTable(name = "EmployeeAddress", joinColumns = {
@JoinColumn(name="empId", referencedColumnName="id", unique=true) 
},
inverseJoinColumns = {
@JoinColumn(name="addressId")
}
)
private List<Address> address=new ArrayList<Address>();

@ManyToMany
@JoinTable(name = "EmployeeProject", joinColumns = {
@JoinColumn(name="empId", referencedColumnName="id")
},
inverseJoinColumns = {
@JoinColumn(name="projectId")
}
)
private Set<Project> projects = new HashSet<Project>();

@ManyToOne
@JoinColumn(name="dept_id", referencedColumnName="deptId")
private Department department;

*/
public EmployeeDetail getDetails() {
	return details;
}


public void setDetails(EmployeeDetail details) {
	this.details = details;
}


/*public Department getDepartment() {
	return department;
}


public void setDepartment(Department department) {
	this.department = department;
}


public Set<Project> getProjects() {
	return projects;
}


public void setProjects(Set<Project> projects) {
	this.projects = projects;
}

*/
/*public void setAddress(List<Address> address) {
	this.address = address;
}


public List<Address> getAddress() {
	return address;
}*/


public Employee(){
 //address.add(new Address());
 //address.add(new Address());
 
}


public int getEmpId() {
	return empId;
}


public void setEmpId(int empId) {
	this.empId = empId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
