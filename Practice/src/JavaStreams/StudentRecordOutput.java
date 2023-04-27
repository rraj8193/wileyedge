package JavaStreams;
import java.util.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentRecordOutput {
	DataOutputStream dataOutput;
	
	public StudentRecordOutput(String outputFile) throws IOException {
		
		dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
	}
	
	public void writer(Student student) throws IOException {
		dataOutput.writeUTF(student.getName());
		dataOutput.writeBoolean(student.getGender());
		dataOutput.writeInt(student.getAge());
		dataOutput.writeFloat(student.getGrade());
		dataOutput.writeFloat(student.getSalary());
		dataOutput.writeUTF(student.getCity());
	}
	
	public void save() throws IOException {
		dataOutput.close();
	}
	
	
	public static void main(String[] args) {

		
		List<Student> listStudent = new ArrayList<>(); 
		
		listStudent.add(new Student("venkat", true, 28, 90.1f,40_00_000.25f,"Hyderabad"));
		listStudent.add(new Student("Anmol", true, 21, 81.5f,8_00_000.80f,"Don't know"));
		listStudent.add(new Student("Shreya", false, 18, 91.1f,8_70_000.80f,"Indore"));
		listStudent.add(new Student("Rishav", true, 19, 95.1f,8_00_000.80f,"Nawada"));
		
		try {
			StudentRecordOutput outputWriter = new StudentRecordOutput("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
			
			for(Student student: listStudent) {
				outputWriter.writer(student);
			}
			
			outputWriter.save();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
