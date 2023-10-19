import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Queue<Integer> queue = new LinkedList<>();
    	
    	while(true) {
    		int info = Integer.parseInt(br.readLine());
    		
    		if(info == -1) {
    			break;
    		}
    		
    		if(info == 0) {
    			queue.poll();
    		}else if(n > queue.size()){
    			queue.offer(info);
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	if(queue.isEmpty()) {
    		sb.append("empty");
    	}
    	
    	while(!queue.isEmpty()) {
    		sb.append(queue.poll()).append(" ");
    	}
    	
    	System.out.print(sb);
    }
}