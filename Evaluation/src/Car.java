
class Car implements Vehicle {
	private int capacity;
	private String fuel;
	private double price;
	
	static final int wheels = 4;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Car(){
	}
	public Car(int capacity, String fuel, double price) {
		super();
		this.capacity = capacity;
		this.fuel = fuel;
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public boolean canCarryPeople(){
		return true;
	}
	public int capacity(){
		return capacity;
	}
	public String modeOfPropulsion(){
		return fuel;
	}
	public Medium movesIn(){
		return Medium.LAND;
	}
	
	
}
