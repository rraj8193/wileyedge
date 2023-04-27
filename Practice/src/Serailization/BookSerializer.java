package Serailization;

import java.io.Serializable;

public class BookSerializer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public BookSerializer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
