
class SavingsAccount extends Account{
	static final float rateOfInterest = 4.5f; //in % annually
	static final double savingWithdrawLimit= 2000; // rupees
	
	public SavingsAccount(String Name, double Balance){
		super(Name,Balance);
	}
	
	String Withdraw(double amount){
		if(getBalance() - amount < savingWithdrawLimit)
			return "Balance Too Low, Can't WITHDRAW ";
		else{
			setBalance(getBalance()-amount);
			return "The new BALANCE is: "+getBalance()+" After WITHDRAWAL";
		}
	}
	
	String Deposit(double amount){
		setBalance(getBalance()+amount);
		return "The new Balance after deposit is Rs. "+getBalance();
	}
	
	void update(int timeInYears){
		setBalance(getBalance()+getBalance()*rateOfInterest/100);
	}
	
	
}
