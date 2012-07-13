
class RacingCar extends Car implements Vehicle{
		
	private double topSpeed;
	private boolean isStreamlined;
	
	public RacingCar(int capacity, String fuel, double price, double topSpeed,
			boolean isStreamlined) {
		super(capacity, fuel, price);
		this.topSpeed = topSpeed;
		this.isStreamlined = isStreamlined;
	}
	public RacingCar(double topSpeed, boolean isStreamlined) {
		super();
		this.topSpeed = topSpeed;
		this.isStreamlined = isStreamlined;
	}
	public RacingCar(){
		super();
	}
	
	public double getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
	public boolean isStreamlined() {
		return isStreamlined;
	}
	public void setStreamlined(boolean isStreamlined) {
		this.isStreamlined = isStreamlined;
	}
	public boolean canCarryPeople(){
		return true;
	}
	public String modeOfPropulsion(){
		return getFuel();
	}
	public int capacity(){
		return getCapacity();
	}
	public Medium movesIn(){
		return Medium.LAND;
	}
	
}
