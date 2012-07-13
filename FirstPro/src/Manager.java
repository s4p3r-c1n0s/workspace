
public interface Manager {
	String OpenAccount(String Name, String Type, double Balance);
	String CloseAccount(int AccountNo);
	String UpdateAccounts(int timeInYears);
}
