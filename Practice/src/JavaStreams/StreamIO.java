package JavaStreams;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamIO {
	
	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
		BufferedOutputStream output = new BufferedOutputStream(fout);
		
		String s = "This is the string data";
		byte[] b_data = s.getBytes();
		
//		System.out.println(Arrays.toString(b_data));
		
		try {
			output.write(b_data);
			output.flush();
			output.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
