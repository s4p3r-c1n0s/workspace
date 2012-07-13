import java.util.ArrayList;

 class Student {
	ArrayList<Address> addressList;
	private String name;
	private int marks;
	private char grade;
	
	public Student(){
		addressList = new ArrayList<Address>();
	}
	public Student(ArrayList<Address> addressList,String name, int marks, char grade){
		setAddressList(addressList);
		setName(name);
		setGrade(grade);
		setMarks(marks);
	}
	
	public void setAddress(Address address){
		addressList.add(address);
	}
	public ArrayList<Address> getAddressList(){
		return this.addressList;
	}
	public int getMarks(){
		return this.marks;
	}
	public char getGrade(){
		return this.grade;
	}
	public String getName(){
		return this.name;
	}
	public void setAddressList(ArrayList<Address> addressList){
		this.addressList=addressList;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setMarks(int marks){
		this.marks=marks;
	}
	public void setGrade(char grade){
		this.grade=grade;
	}
}
