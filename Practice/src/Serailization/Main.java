package Serailization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Rishav Raj\\Desktop\\data.ser");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		
		BookSerializer book = new BookSerializer(108,"Java Essentials");
		
		try {
			out.writeObject(book);
			out.close();
			System.out.println("Task Completed");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
