package mypack;

public class StockServiceImpl implements StockService {

	public StockServiceImpl() {
		System.out.println("StockServiceImpl()");
	}
	public double getExchangeRate() {
		System.out.println("getExchangeRate()");
		return 44.50;
	}
};