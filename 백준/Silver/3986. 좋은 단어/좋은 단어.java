import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	int count = 0;
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();	
			int len = str.length();
			stack.push(str.charAt(0));
			
			for(int j = 1; j < len; j++) {
				char nowCh = str.charAt(j);
				if(!stack.isEmpty()) {
					char prevCh = stack.peek();
					if(prevCh == nowCh) {
						stack.pop();
						continue;
					}
				}
				stack.push(nowCh);
			}
			
			if(stack.isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
    }
}