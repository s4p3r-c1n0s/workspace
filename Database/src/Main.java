import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private static void addStudentMain(){
		DOA doa= DOA.getObject();
		GUIStudent guiStudent = new GUIStudent();
		guiStudent.setAll();
		try {
			doa.addStudent(guiStudent.getStudentObject());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		guiStudent.getAll();
	}
	private static void viewStudentsMain(){
		DOA doa = DOA.getObject();
		try {
			doa.viewAllStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void viewAddressesMain(){
		DOA doa = DOA.getObject();
		try {
			doa.viewAllAddresses();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void addAddressMain(int studentId){
		DOA doa= DOA.getObject();
		GUIAddress guiAddress = new GUIAddress();
		guiAddress.setAll();
		try {
			doa.addAddress(guiAddress.getAddressObject(),studentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		guiAddress.getAll();
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		char ch;
		/*while(true){
			System.out.println("Start");
			ch = sc.nextLine().charAt(0);
			switch(ch){
				case '1' : viewStudentsMain();break;
				case '2' : viewAddressesMain();break;
				case '3' : addAddressMain(6);break;
				case '4' : addStudentMain(); break;
				case '5' : System.exit(0);
				default : continue;
			}
			
		}*/
		
		DOA doa = DOA.getObject();
		try {
			doa.updateStudent("Latika");
			//doa.deleteFromStudents(3);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	