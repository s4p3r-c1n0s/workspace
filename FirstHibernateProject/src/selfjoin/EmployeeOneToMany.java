package selfjoin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class EmployeeOneToMany {
     
    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue
    private Long employeeId;
     
    @Column(name="FIRSTNAME")
    private String firstname;
     
    @Column(name="LASTNAME")
    private String lastname;
     
    @ManyToOne
    @JoinColumn(name="manager_id")
    private EmployeeOneToMany manager;
 
    @OneToMany(mappedBy="manager")
    private Set<EmployeeOneToMany> subordinates = new HashSet<EmployeeOneToMany>();
 
    public EmployeeOneToMany() {
    }
 
    public EmployeeOneToMany(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public EmployeeOneToMany getManager() {
		return manager;
	}

	public void setManager(EmployeeOneToMany manager) {
		this.manager = manager;
	}

	public Set<EmployeeOneToMany> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<EmployeeOneToMany> subordinates) {
		this.subordinates = subordinates;
	}
         
    
}
