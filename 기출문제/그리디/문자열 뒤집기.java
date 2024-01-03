import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int zeroCnt = 0;
		int oneCnt = 0;
		for(int i=0; i<s.length()-1; i++) {
			char c = s.charAt(i);
			if(c == '1' && c != s.charAt(i+1)) {
				oneCnt++;
			}else if(c == '0' && c != s.charAt(i+1)){
				zeroCnt++;
			}

			if(i == s.length()-2) {
				char last = s.charAt(i+1);
				if(last == '0') {
					zeroCnt++;
				}else {
					oneCnt++;
				}
			}
		}
		
		int min = Math.min(zeroCnt, oneCnt);
		System.out.println(min);
	}
}
