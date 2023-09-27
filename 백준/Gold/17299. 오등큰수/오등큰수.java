import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static int MAX = 1000000;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[MAX+1];
    	int[] count = new int[MAX+1];
    	Stack<Integer> stack = new Stack<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i=0; i<n; i++) {
    		count[arr[i]] += 1;
    	}
    	
    	StringBuilder sb = new StringBuilder(); 
    	for(int i=0; i<n; i++) {
    		while(!stack.isEmpty() && count[arr[stack.peek()]] < count[arr[i]]) {
    			arr[stack.pop()] = arr[i];
    		}
    		
    		stack.push(i);
    	}
    	
    	while(!stack.isEmpty()) {
    		arr[stack.pop()] = -1;
    	}
    	
    	for(int i=0; i<n; i++) {
    		sb.append(arr[i]).append(" ");
    	}
    	
    	System.out.print(sb);
    }
}