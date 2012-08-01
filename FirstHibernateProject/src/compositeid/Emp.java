package compositeid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
@Entity
@Table(name="ExpEmp")
public class Emp {

	double salary;

	@EmbeddedId
	EmployeePK primaryKey;
	
	public Emp() {
	}

	
	public EmployeePK getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(EmployeePK pk) {
		primaryKey = pk;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


}
