import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
	public static int n;
	public static int[] d;
	public static int count = 0;
	public static int dpCount = 0;
	
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			count++;
			return 1;
		}else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static int fibonacci(int n) {
		d[1] = 1;
		d[2] = 1;
		for(int i=3; i<=n; i++) {
			dpCount++;
			d[i] = d[i-1] + d[i-2];
		}
		
		return d[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(count + " " + dpCount);
	}
}