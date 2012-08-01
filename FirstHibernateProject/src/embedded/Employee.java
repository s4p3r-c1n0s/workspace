package embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column
	private double salary;
	
@Embedded
@AttributeOverrides({
    @AttributeOverride(name="state",
                       column=@Column(name="ADDR_STATE")),
    @AttributeOverride(name="city",
                       column=@Column(name="ADDR_City"))
})
private Address address;



	public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
 

}
