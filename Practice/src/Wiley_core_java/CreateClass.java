package Wiley_core_java;

public class CreateClass implements Cloneable {
	int a = 10;
	void add() {
		System.out.println("Add Method Running");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, CloneNotSupportedException {
		
		CreateClass cc = new CreateClass();
		System.out.println("-------Using new Keyword--------");
		cc.add();	
		System.out.println(cc);
		System.out.println();
		
		try {
			Class c = Class.forName("Wiley_core_java.CreateClass");
			CreateClass obj = (CreateClass) c.newInstance();
			System.out.println("-------Using Class.newInstance() method--------");
			obj.add();
			System.out.println(obj);
			
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("-------Using object.Clone--------");
		
		CreateClass objClone = (CreateClass) cc.clone();
		objClone.add();
		System.out.println(objClone);
	}

}
