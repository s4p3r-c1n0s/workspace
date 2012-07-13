import java.util.Scanner;

public class Banking {
	public static void main(String args[]){
		
		UIManager Mgr = new UIManager();
		UIOfficer Ofr = new UIOfficer();
		Scanner sc = new Scanner(System.in);	

		for(;;) {
			System.out.println("Login as:\n\t1>> Manager\n\t2>> Officer\n\t3>> Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			case 1 : 
				Mgr.ManagerFunctions();
				break;
			case 2 : 
				Ofr.OfficerFunctions();
				break;
			case 3 : System.exit(0);
			default : continue;
			}
		}
	}
}
