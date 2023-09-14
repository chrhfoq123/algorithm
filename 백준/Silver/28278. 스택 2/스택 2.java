import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<>();
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<n; i++) {
    		int a = sc.nextInt();
    		
    		if(a == 1) {
    			int b = sc.nextInt();
    			stack.push(b);
    		}else if(a == 2) {
    			if(!stack.isEmpty()) {
    				sb.append(stack.pop()).append("\n");
    			}else {
    				sb.append(-1).append("\n");
    			}
    		}else if(a == 3) {
    			sb.append(stack.size()).append("\n");
    		}else if(a == 4) {
    			if(!stack.isEmpty()) {
    				sb.append(0).append("\n");
    			}else {
    				sb.append(1).append("\n");
    			}
    		}else {
    			if(!stack.isEmpty()) {
    				sb.append(stack.peek()).append("\n");
    			}else {
    				sb.append(-1).append("\n");
    			}
    		}
    	}
    	
    	System.out.println(sb);
    }
}