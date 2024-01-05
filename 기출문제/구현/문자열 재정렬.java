import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<Character> list = new ArrayList<>();
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 48 && c <= 57) {
				sum += c-'0';
			}else {
				list.add(c);
			}
		}
		
		Collections.sort(list);
		
		for(char c : list) {
			System.out.print(c);
		}
		System.out.print(sum);
	}
}
