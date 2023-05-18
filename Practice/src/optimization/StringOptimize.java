package optimization;

public class StringOptimize {

	
	public static void main(String[] args) {
		
		
		long start = System.currentTimeMillis();
		
		String s = "";
		for(int i=0;i<100000;i++) {
			s+=i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<100000;i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
