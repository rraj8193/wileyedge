package JavaStreams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStream {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fin = new FileInputStream("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
		BufferedInputStream input = new BufferedInputStream(fin);
		int i;
		try {
			while ((i = input.read()) != -1) {
				System.out.println((char) i);
			}
			fin.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
