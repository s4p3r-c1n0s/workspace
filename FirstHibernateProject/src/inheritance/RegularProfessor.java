package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value="RegProf")

@Table(name="regular_professor")
public class RegularProfessor extends Professor {
	
private double salary;
private double pensionContribution;
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public double getPensionContribution() {
	return pensionContribution;
}
public void setPensionContribution(double pensionContribution) {
	this.pensionContribution = pensionContribution;
}


}
