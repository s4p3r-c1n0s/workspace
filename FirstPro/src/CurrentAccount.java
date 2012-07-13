
class CurrentAccount extends Account{
	static final int overDraftLimit = -10000; //rupees
	static final int finePer1000 = 100; //rupees
	
	public CurrentAccount(String Name, double Balance){
		super(Name,Balance);
	}
	
	String Withdraw(double amount){
		if(getBalance() - amount > overDraftLimit){
			setBalance(getBalance()-amount);
			if(getBalance() < 0) setBalance(getBalance() + (getBalance()/1000 * finePer1000));
			return "The new Balance is Rs. "+getBalance()+" after WITHDRAWAL";
			
		}
		else
			return "Balance too Low, Can't Withdraw";
	}
	
	String Deposit(double amount){
		setBalance(getBalance()+amount);
		return "The new Balance after deposit is Rs. "+getBalance();
	}
}
