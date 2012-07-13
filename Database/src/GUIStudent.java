import java.util.*;

class GUIStudent {
	private Student student;
	
	public GUIStudent(){
		student = new Student();
	}	
	public void setAll(){
		student = new Student();
		GUIAddress guiAddress =new GUIAddress(); 
		Scanner sc = new Scanner(System.in);
		System.out.print("Name : ");
		student.setName(sc.nextLine());
		System.out.print("Marks : ");
		student.setMarks(sc.nextInt());
		sc.nextLine();
		System.out.print("Grade : ");
		student.setGrade(sc.nextLine().charAt(0));
		System.out.print("How many Addresses?");
		int i=sc.nextInt(); sc.nextLine();
		while(i>0){
			guiAddress.setAll();
			student.setAddress(guiAddress.getAddressObject());
			i--;
		}
	}
	public void getAll(){
		System.out.print("Name:"+student.getName());
		System.out.print(", Marks:"+student.getMarks());
		System.out.print(", Grade:"+student.getGrade());
		System.out.println();
		GUIAddress guiAddress = new GUIAddress();
		Iterator<Address> it = student.getAddressList().iterator();
		while(it.hasNext()){
			guiAddress.setAddressObject(it.next());
			guiAddress.getAll();
		}
	}
	public Student getStudentObject(){
		return this.student;
	}
	
}
