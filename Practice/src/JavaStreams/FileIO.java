package JavaStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {

	public static void outputMethod() throws IOException {
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Rishav Raj\\Desktop\\data2.txt");
		String data = "This is jfsd course";
		byte[] b = data.getBytes();
		fout.write(b);
		fout.close();
	}

	public static void inputMethod() throws IOException {
		FileInputStream fin = new FileInputStream("C:\\Users\\Rishav Raj\\Desktop\\data2.txt");
		int i;
		try {
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
			fin.close();
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) throws IOException {

		outputMethod();
		inputMethod();

	}

}
