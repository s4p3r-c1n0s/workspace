import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class id_string implements Serializable{
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="ID", nullable =false)
	private int id;
	@Column(name ="STRING", nullable =false)
	private String str;
	
	public id_string() {
		super();
		// TODO Auto-generated constructor stub
	}
	public id_string(int id, String str) {
		super();
		this.id = id;
		this.str = str;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
