package AlbumCart;

public class album {
	private String name;
	public album() {
		super();
		// TODO Auto-generated constructor stub
	}
	public album(String name, int qty, double price, String category) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private int qty;
	private double price;
	private String category;
}
