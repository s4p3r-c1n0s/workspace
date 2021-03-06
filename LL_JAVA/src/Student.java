class Student extends Person{
	private int rollNo;
	private String dept;
	
	static int autoIncr=1;
	
	Student(String Name, char Gender, String State){
		super(Name,Gender,State);
	}
	
	Student(String Name, char Gender, String State, int RollNo, String Dept){
		super(Name,Gender,State);
		setRollNo();
		setDept(Dept);
	}
		
	public void setRollNo(){
		rollNo=autoIncr++;
	}
	public int getRollNo(){
		return rollNo;
	}
	public void setDept(String Dept){
		dept=Dept;
	}
	public String getDept(){
		return dept;
	}
}