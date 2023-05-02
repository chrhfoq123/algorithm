import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			
			if(s[0].equals("push")) {
				queue.offer(Integer.parseInt(s[1]));
			}else if(s[0].equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.poll()).append("\n");
				}
			}else if(s[0].equals("size")) {
				sb.append(queue.size()).append("\n");
			}else if(s[0].equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(s[0].equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.peek()).append("\n");
				}
			}else if(s[0].equals("back")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}