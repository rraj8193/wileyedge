package JavaStreams;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
		DataOutputStream output = new DataOutputStream(fout);
		
		
		StudentData data = new StudentData("Rishav","Male",22,90);
		System.out.print(data.toString());
//		byte[] b_data = data.toString().getBytes();
		output.writeBytes(data.toString());
		
		
		StudentData data2 = new StudentData("Rahul","Male",20,95);	
		System.out.print(data2.toString());
//		byte[] b2_data = data2.toString().getBytes();
		output.writeBytes(data2.toString());
//		output.write(b_data);
//		output.write(b2_data);
		output.flush();
		output.close();
		
	}

}
