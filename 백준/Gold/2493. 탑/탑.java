import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<>();
    	Stack<Integer> index = new Stack<>();
    	
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=1; i<=n; i++) {
    		int height = Integer.parseInt(st.nextToken());
    		
    		while(true) {
    			if(stack.isEmpty()) {
    				sb.append("0 ");
    				stack.push(height);
    				index.push(i);
    				break;
    			}else {
    				if(stack.peek() > height) {
    					sb.append(index.peek() + " ");
    					stack.push(height);
    					index.push(i);
    					break;
    				}else {
    					stack.pop();
    					index.pop();
    				}
    			}
    		}
    	}
    	
    	System.out.print(sb);
    }
}