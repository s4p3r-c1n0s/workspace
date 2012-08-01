package selfjoin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EmployeeManyToMany {
	  @Id
	    @Column(name="EMPLOYEE_ID")
	    @GeneratedValue
	    private Long employeeId;
	     
	    @Column(name="FIRSTNAME")
	    private String firstname;
	     
	    @Column(name="LASTNAME")
	    private String lastname;
	     
	 
	    @ManyToMany
	    @JoinTable(name="EMPLOYEE_COLLEAGUE",
	        joinColumns={@JoinColumn(name="EMPLOYEE_ID")},
	        inverseJoinColumns={@JoinColumn(name="COLLEAGUE_ID")})
	    private Set<EmployeeManyToMany> colleagues = new HashSet<EmployeeManyToMany>();
	 
	    @ManyToMany(mappedBy="colleagues")
	    private Set<EmployeeManyToMany> teammates = new HashSet<EmployeeManyToMany>();

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

		public Set<EmployeeManyToMany> getColleagues() {
			return colleagues;
		}

		public void setColleagues(Set<EmployeeManyToMany> colleagues) {
			this.colleagues = colleagues;
		}

		public Set<EmployeeManyToMany> getTeammates() {
			return teammates;
		}

		public void setTeammates(Set<EmployeeManyToMany> teammates) {
			this.teammates = teammates;
		}
	 
	    
}
