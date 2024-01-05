import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int len = n.length()/2;
		
		int leftSum = 0;
		for(int i=0; i<len; i++) {
			int num = n.charAt(i) - '0';
			leftSum += num;
		}
		
		int rightSum = 0;
		for(int i=n.length()-1; i>=len; i--) {
			int num = n.charAt(i) - '0';
			rightSum += num;
		}
		
		if(leftSum == rightSum) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
	}
}