
class RawMaterial {
	private String name;
	private double ratePerUnit;
	public RawMaterial(){
		super();
	}
	public RawMaterial(String name, double ratePerUnit) {
		super();
		this.name = name;
		this.ratePerUnit = ratePerUnit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
}
