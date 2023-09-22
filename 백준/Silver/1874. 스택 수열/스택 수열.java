import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static int val = 1;
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	Stack<Integer> stack = new Stack<>();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++) {
    		int num = sc.nextInt();
    		
    		for(; val<=num; val++) {
    			stack.push(val);
    			sb.append("+").append("\n");
    		}
    		
    		if(stack.peek() == num) {
    			stack.pop();
    			sb.append("-").append("\n");
    		}
    	}
    	
    	if(!stack.isEmpty()) {
    		System.out.print("NO");
    	}else {
    		System.out.print(sb);
    	}
    }
}