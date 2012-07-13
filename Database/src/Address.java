
class Address {
	
	private String street;
	private String city;
	private int pincode;
	private int sid;
	
	public Address(){
	}
	
	public Address(String street, String city, int pincode,int sid) {
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.sid = sid;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
