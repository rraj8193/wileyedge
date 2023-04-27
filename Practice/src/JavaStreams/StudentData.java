package JavaStreams;


public class StudentData {
	private String name,gender;
	private int age,grade;
	
	public static int counter = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public StudentData(String name, String gender, int age, int grade) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
		counter++;
	}
	public String toString() {
		return counter+" "+name+" "+age+" "+gender+" "+" "+grade+"\n";
	}
	
}
