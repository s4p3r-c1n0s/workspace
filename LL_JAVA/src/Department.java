import java.util.*; 

class Department{
	private String dName;
	private int dCapacity;
	private Faculty dFaculty;
	private ArrayList<Student> dStudents;
	
	int autoIncr=1;
	
	Department(String Name, int Capacity, Faculty Faculty){
		setName(Name);
		setCapacity(Capacity);
		setFaculty(Faculty);
	}
	
	public void setName(String Name){
		dName=Name;
	}
	public String getName(){
		return dName;
	}
	public void setCapacity(int Capacity){
		dCapacity=Capacity;
	}
	public int getCapacity(){
		return dCapacity;
	}
	public void setFaculty(Faculty Faculty){
		dFaculty=Faculty;
	}
	public Faculty getFaculty(){
		return dFaculty;
	}
	
	public boolean upgradeFaculty(String Qualification, int Experience, Faculty Faculty){
		if(Faculty.getQualification().equals(Qualification) && Faculty.getExperience() < Experience){
			dFaculty = Faculty;
			return true;
		}
		else 
			return false;
	}
	
	public int addStudent(Student Student, String Dept){
		if(Student == null)
			return 0;
		Student.setDept(Dept);
		dStudents.add(Student);
		return dStudents.size();
	}
}