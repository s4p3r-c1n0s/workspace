package compositeid;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(EmployeePK1.class)

@Entity
@Table(name="ExpEmp1")
public class Emp1 {
	
@Id String empName;
@Id Date birthDay;


double salary;
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Date getBirthDay() {
	return birthDay;
}
public void setBirthDay(Date birthDay) {
	this.birthDay = birthDay;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}