package collectionmapping;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EmpCollection")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column
	private double salary;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfJoining;

	@ElementCollection
	   @CollectionTable(name="emp_phone", joinColumns=@JoinColumn(name="emp_id"))
	   @Column(name="phoneNumber")
	private List<String> phoneNo;
	
	@ElementCollection  
    private Set<String> nickNames = new HashSet<String>();
	
	@ElementCollection
	@CollectionTable(name="emp_email", joinColumns=@JoinColumn(name="emp_id"))
	@MapKeyColumn(name="emailId")
	   @Column(name="email")
	private Map<String,String> email = new HashMap<String, String>();
	
	public List<String> getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
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
