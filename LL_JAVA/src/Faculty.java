public class Faculty extends Person{
	private String qualification;
	private double experience;
	
	Faculty(String Name, char Gender, String State, String Qualification, double Experience){
		super(Name,Gender,State);
		setExperience(Experience);
		setQualification(Qualification);
	}
	
	public String getQualification(){
		return qualification;
	}
	public double getExperience(){
		return experience;
	}
	public void setExperience(double Experience){
		experience=Experience;
	}
	public void setQualification(String Qualification){
		qualification=Qualification;
	}
}