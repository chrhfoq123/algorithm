import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0; i<n; i++) {
    		int h = Integer.parseInt(br.readLine());
    		stack.push(h);
    	}
    	
    	int cnt = 1;
    	int item = 0;
    	while(!stack.isEmpty()) {
    		if(item == 0) {
    			item = stack.pop();
    		}else {
    			int tmp = stack.pop();
    			if(item < tmp) {
    				cnt++;
    				item = tmp;
    			}
    		}
    	}
    	
    	System.out.print(cnt);
    }
}