import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int start = s.charAt(0) - '0';
		
		for(int i=1; i<s.length(); i++) {
			int num = s.charAt(i) - '0';
			if(start <= 1 || num <= 1) {
				start += num;
			}else {
				start *= num;
			}
		}
		
		System.out.println(start);
	}
}
