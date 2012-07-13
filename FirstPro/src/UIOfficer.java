import java.util.Scanner;

class UIOfficer{
	Officer officer;
	void OfficerFunctions(){
		officer = BankFactory.getBankObject();
		
		double amount;
		int AccountNo;
		
		Scanner sc = new Scanner(System.in);
				
		for(;;) {
			
			System.out.println("Officer Functions:\n\t1>> Withdraw\n\t2>> Deposit\n\t3>> Exit");
		
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			case 1 : 
				amount = sc.nextDouble();
				sc.nextLine();
				AccountNo = sc.nextInt();
				sc.nextLine();
				System.out.println(officer.WithdrawFromAccount(amount,AccountNo));
				break;
			case 2 : 
				amount = sc.nextDouble();
				sc.nextLine();
				AccountNo = sc.nextInt();
				sc.nextLine();
				System.out.println(officer.DepositToAccount(amount,AccountNo));
				break;
			case 3 : return;
			default : continue;
			}
		}
		
	}
}