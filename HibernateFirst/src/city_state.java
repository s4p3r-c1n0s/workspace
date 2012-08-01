import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class city_state  implements Serializable{
	@Column(name="CITY_NAME", nullable=false)
	private String city;
	@Column(name="STATE_NAME", nullable=false)
	private String state;
	public city_state(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	public city_state() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
