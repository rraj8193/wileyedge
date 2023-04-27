package JavaStreams;

public class Student {
	private String name;
	private boolean gender; // true: male, false: female
	private int age;
	private float grade;
	private float salary;
	private String city;

	public Student(String name, boolean gender, int age, float grade,float salary,String city) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
		this.salary = salary;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
}
