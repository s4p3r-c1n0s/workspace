class Person{
	private String name;
	private char gender;
	private String state;
	
	enum Gender{
		male, female;
	}
	
	Person(String Name, char Gender, String State){
		setName(Name);
		setGender(Gender);
		setState(State);
	}
	
	public String getName(){
		return name;
	}
	public char getGender(){
		return gender;
	}
	public String getState(){
		return state;
	}
	
	public void setName(String Name){
		name=Name;
	}
	public void setState(String State){
		state=State;
	}
	public void setGender(char Gender){
		gender=Gender;
	}
}