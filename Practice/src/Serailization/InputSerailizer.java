package Serailization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InputSerailizer {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("C:\\Users\\Rishav Raj\\Desktop\\data.ser");
		ObjectInputStream in = new ObjectInputStream(fin);
		
		try {
			BookSerializer book = (BookSerializer) in.readObject();
			System.out.println(book.name);
			System.out.println(book.id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
