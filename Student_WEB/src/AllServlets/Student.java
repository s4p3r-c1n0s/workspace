package AllServlets;

public class Student {
	private String name;
	private int age;
	private String password;
	private char sex;
	private String course[];
	public Student(String name, int age, String password, char sex,String[] course) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
		this.sex = sex;
		this.course = course;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	
}
