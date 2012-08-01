package unidirectionalmapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empDetails")
public class EmployeeDetail {
     
    @Id
    @Column(name="detail_id")
    private int employeeId;
     
    
  /* @OneToOne
   @JoinColumn(name="empid", referencedColumnName="id")
       private Employee employee;
*/
    @Column 
    private String cellphone;
    
    @Column 
    private int noOfDependents;
    
    
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int i) {
		this.employeeId = i;
	}

	
	
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getNoOfDependents() {
		return noOfDependents;
	}

	public void setNoOfDependents(int noOfDependents) {
		this.noOfDependents = noOfDependents;
	}

/*	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
*/ 
  
 
}