import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	Stack<Integer> stack = new Stack<>();
    	int[] student = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		student[i] = sc.nextInt();
    	}
    	
    	int getOrder = 1;
    	for(int i=0; i<n; i++) {
    		if(student[i] != getOrder) {
    			if(!stack.isEmpty() && stack.peek() == getOrder) {
    				stack.pop();
    				i--;
    				getOrder++;
    			}else {
    				stack.push(student[i]);
    			}
    		}else {
    			getOrder++;
    		}
    	}
    	
    	boolean answer = true;
    	for(int i=0; i<stack.size(); i++) {
    		int order = stack.pop();
    		if(order == getOrder) {
    			getOrder++;
    		}else {
    			answer = false;
    			break;
    		}
    	}
    	
    	if(answer) {
    		System.out.println("Nice");
    	}else {
    		System.out.println("Sad");
    	}
    }
}