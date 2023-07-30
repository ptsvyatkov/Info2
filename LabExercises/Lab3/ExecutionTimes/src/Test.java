
public class Test {

	public static int sum;
	public static int n;
	
	

	public static void main(String[] args) {
		Test test = new Test();
		n= 0;
		long sum= 0;
		long start = System.currentTimeMillis();
		test.fragment7(n = 10);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	
	}
		private int fragment1(int n) {
			// Fragment 1
		for ( int i = 0; i <n; i ++)
		    sum ++;
		return sum;
		}
		
		private int fragment2(int n) {
		// Fragment #2
		for ( int i = 0; i < n; i ++)
		    for ( int j = 0; j < n; j ++)
		        sum++;
		return sum;
		}
		private int fragment3(int n) {
			// Fragment #3
			for ( int i = 0; i < n; i ++)
			    for ( int j = i; j < n; j ++)
			        sum++;
			return sum;
	}
		private int fragment4(int n) {
			// Fragment #3
			for ( int i = 0; i < n; i ++)
			    for ( int j = i; j < n; j ++)
			        sum++;
			return sum;
	}
		private int fragment7(int n) {
		// Fragment #7
		for ( int i = 1; i < n; i ++)
		    for ( int j = 0; j < n*n; j ++)
		        if (j % i == 0)
		           for (int k = 0; k < j; k++)
		               sum++;
		return sum;
}
}
	

