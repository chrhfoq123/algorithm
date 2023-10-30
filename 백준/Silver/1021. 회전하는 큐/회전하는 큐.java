import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	LinkedList<Integer> deque = new LinkedList<Integer>(); 
    	
    	for(int i=1; i<=n; i++) {
    		deque.offer(i);
    	}
    	
    	int cnt = 0;
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<m; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		while(deque.peekFirst() != num) {
    			if(deque.indexOf(num) <= (deque.size()/2)) {
    				deque.offerLast(deque.pollFirst());
    			}else {
    				deque.offerFirst(deque.pollLast());
    			}
    			cnt++;
    		}
    		
    		if(deque.peekFirst() == num) {
    			deque.pollFirst();
    		}
    	}
    	
    	System.out.println(cnt);
    }
}