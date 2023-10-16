import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());

    	for(int i=0; i<t; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		int cnt = 0;
    		Queue<int[]> queue = new LinkedList<>();
    		
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			queue.offer(new int[] {j, Integer.parseInt(st.nextToken())});
    		}
    		
    		while(true) {
    			int[] item = queue.poll();
    			boolean flag = true;
    			
    			for(int q[] : queue) {
    				if(q[1] > item[1]) {
    					flag = false;
    					break;
    				}
    			}
    			
    			if(flag) {
    				cnt++;
    				if(item[0] == m) {
    					break;
    				}
    			}else {
    				queue.offer(item);
    			}
    		}
    		
    		System.out.println(cnt);
    	}
    }
}