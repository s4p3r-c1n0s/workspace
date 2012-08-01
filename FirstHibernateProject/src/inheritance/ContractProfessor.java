package inheritance;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value="ConProf")
@Table(name="contract_professor")
public class ContractProfessor extends Professor {
    @Column(name="D_RATE")
    private int dailyRate;
    private int term;
    
    public int getDailyRate() {
        return dailyRate;
    }
    
    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }
    
    public int getTerm() {
        return term;
    }
    
    public void setTerm(int term) {
        this.term = term;
    }

    public String toString() {
        return "ContractProfessor id: " + getId() + " name: " + getName();
    }
}
