package singletable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

enum EmployeeStatus {FULL_TIME, PART_TIME, CONTRACT}

@Entity
//@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	
	private double salary;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfJoining;

	@Transient
	int count;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus empStatus;
	
	
	public EmployeeStatus getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(EmployeeStatus empStatus) {
		this.empStatus = empStatus;
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
 
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", salary=" + salary + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}
	

}
