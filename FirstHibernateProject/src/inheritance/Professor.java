package inheritance;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
//@Entity
//@Table(name="Professor")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="EMP_TYPE")
*/

//@Inheritance(strategy=InheritanceType.JOINED)
public class Professor  {

	@Id private int id;
    private String name;
   
    @Column(name="S_DATE")
    private Date startDate;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String toString() {
        return "Professor id: " + getId() + " name: " + getName();
    }
}
