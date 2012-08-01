package compositeid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class EmployeePK implements Serializable {
	
@Column(name="empName", length=30)	
private String name;

@GeneratedValue(strategy=GenerationType.AUTO)
private long id;

public EmployeePK() {
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public int hashCode() {
return (int) (name.hashCode() + id);
}
public boolean equals(Object obj) {
if (obj == this) return true;
if (!(obj instanceof EmployeePK)) return false;
if (obj == null) return false;
EmployeePK pk = (EmployeePK) obj;
return pk.id == id && pk.name.equals(name);
}
}