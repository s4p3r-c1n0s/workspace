
abstract class Account {
	private int acc_no;
	private double balance;
	private String name;
	
	static int autoIncr=1000;
	
	abstract String Deposit(double amount);
	abstract String Withdraw(double amount);
	
	public Account(String Name, double Balance){
		this();
		name = Name;
		balance = Balance;
	}
	public Account(){
		if (acc_no==0)	acc_no = autoIncr++;
	}
	
	public String getName(){return name;}
	public double getBalance(){return balance;}
	public int getAccountNo(){return acc_no;}
	
	public void setName(String Name){name = Name;}
	public void setBalance(double Balance) {balance = Balance;}

}
