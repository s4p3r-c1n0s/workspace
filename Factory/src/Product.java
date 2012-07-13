
class Product {
	private String productName;
	private double productPrice;
	private int productQty;
	public Product(){
		super();
	}
	public Product(String productName, double productPrice, int productQty) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
}
