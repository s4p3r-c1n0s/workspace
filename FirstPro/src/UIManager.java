import java.util.Scanner;

class UIManager{
	Manager manager;
	void ManagerFunctions(){
		manager = BankFactory.getBankObject();
		
		String Name, Type; 
		double Balance;
		int AccountNo, timeInYears;
		
		Scanner sc = new Scanner(System.in);
				
		for(;;) {
			
			System.out.println("Manager Functions:\n\t0>> Open Account\n\t1>> Cloase Account\n\t2>> Update Account\n\t3>> Exit");
		
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
			case 0 : 
				Name = sc.nextLine();
				Type = sc.nextLine();
				Balance = sc.nextDouble();
				sc.nextLine();
				System.out.println(manager.OpenAccount(Name,Type, Balance));
				break;
			case 1 : 
				AccountNo = sc.nextInt();
				sc.nextLine();
				System.out.println(manager.CloseAccount(AccountNo));
				break;
			case 2 :
				timeInYears = sc.nextInt();
				sc.nextLine();
				manager.UpdateAccounts(timeInYears);
				break;
			case 3 : return;
			default : continue;
			}
		}
	}
}