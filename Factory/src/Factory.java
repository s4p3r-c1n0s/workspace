import java.util.*;

class Factory {
	private String name;
	private HashMap<String,Product> products;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Product> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}
	public Factory(String name, HashMap<String, Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

	public int fetchHashMap(){
		
	}
	public int manufactureProduct(String productName, double laborCost, RawMaterial rawMaterial, int rawMaterialQty){
		int found = searchDoaProductName(productName);
		if(found!=0){
			Product product = new Product(productName,(laborCost + rawMaterialQty * rawMaterial.getRatePerUnit()),1);
		}
		else incrementDoaProductQty(productName);
		return 0;
	}
}
