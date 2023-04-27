package Wiley_core_java;

abstract interface NewInterface{
	public abstract void method() throws Exception;
}

class SampleClass implements NewInterface{

	@Override
	public void method() throws Exception {
		// TODO Auto-generated method stub
		
		throw new Exception("This error is thrown from method in Sample Class");
		
	}
	
}
	


public class InterfaceException{
	
		public static void main(String[] args) {
			try {
				new SampleClass().method();
			}
			catch(Exception e) {
				System.out.println(e);
//				e.printStackTrace();
			}
		
		}
		
	}


