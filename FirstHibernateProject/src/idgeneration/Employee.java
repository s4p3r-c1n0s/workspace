package idgeneration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="employeegen")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@TableGenerator(
        name="empGen", 
        table="ID_GEN", 
        pkColumnName="GEN_KEY", 
        valueColumnName="GEN_VALUE", 
        pkColumnValue="empId") 
       public class Employee {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	// @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empGen")
	private int empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column
	private double salary;
	



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
