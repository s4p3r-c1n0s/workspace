package compositeid;

import java.io.Serializable;
import java.util.Date;

public class EmployeePK1 implements Serializable {
	private String empName;
	private Date birthDay;
	public EmployeePK1() {
	}
	public String getName() {
	return empName;
	}
	public void setName(String name) {
	empName = name;
	}
	public Date getDateOfBirth() {
	return birthDay;
	}
	public void setDateOfBirth(Date date) {
	birthDay = date;
	}
	public int hashCode() {
	return (int) empName.hashCode();
	}
	public boolean equals(Object obj) {
	if (obj == this) return true;
	if (!(obj instanceof EmployeePK1)) return false;
	if (obj == null) return false;
	EmployeePK1 pk = (EmployeePK1) obj;
	return pk.birthDay == birthDay && pk.empName.equals(empName);
	}
	}