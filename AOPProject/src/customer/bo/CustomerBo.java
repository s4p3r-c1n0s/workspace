package customer.bo;

public interface CustomerBo {

	void addCustomer();
	void addCustomer(String name);
	void addCustomer(String name, int z);
	String addCustomerReturnValue();
	
	void addCustomerThrowException() throws Exception;
	
	void addCustomerAround(String name);
}