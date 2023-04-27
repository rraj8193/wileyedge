package JavaStreams;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Rishav Raj\\Desktop\\data2.txt");
		DataOutputStream out = new DataOutputStream(fout);
		out.writeBytes("This is the second data file");

	}

}
