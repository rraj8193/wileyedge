package JavaStreams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class StudentRecordInput {
	
DataInputStream dataInput;
	
	public StudentRecordInput(String inputFile) throws FileNotFoundException {
		dataInput = new DataInputStream(new FileInputStream(inputFile));
	}
	
	//data in byte
	public List<Student> readAll() throws IOException {
		List<Student> listStudent = new ArrayList<>();
		
		try {
			while(true) {
//				String name  = dataInput.readUTF();
//				boolean gender = dataInput.readBoolean();
//				int age = dataInput.readInt();
//				float grade = dataInput.readFloat();
//				float salary = dataInput.readFloat();
//				String city = dataInput.readUTF();
				
				String city = dataInput.readUTF();
				String name  = dataInput.readUTF();
				boolean gender = dataInput.readBoolean();
				int age = dataInput.readInt();
				float grade = dataInput.readFloat();
				float salary = dataInput.readFloat();
				
				
				System.out.println("Name: " + name);
				
				Student student = new Student(name, gender, age, grade,salary,city);
				
				listStudent.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception

//			e.printStackTrace();
		
		}
		
		dataInput.close();
		return listStudent;
	}
	

	public static void main(String[] args) {
//		if(args.length < 1) {
//			System.out.println("Please provide output file");
//			System.exit(0);
//		}
		
		String inputFile = "C:\\\\Users\\\\Rishav Raj\\\\Desktop\\\\data.txt";
		
		try {
			StudentRecordInput reader = new StudentRecordInput(inputFile);
			List<Student> listOfStudents = reader.readAll();
			
			for(Student student: listOfStudents) {
				System.out.print(student.getName() + "\t");
				System.out.print(student.getGender() + "\t");
				System.out.print(student.getAge() + "\t");
				System.out.print(student.getGrade()+"\t");
				System.out.print(student.getCity()+"\t");
				System.out.println(student.getSalary());
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
