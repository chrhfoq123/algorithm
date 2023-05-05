import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			
			if(s[0].equals("push_front")) {
				deque.offerFirst(Integer.parseInt(s[1]));
			}else if(s[0].equals("push_back")) {
				deque.offerLast(Integer.parseInt(s[1]));
			}else if(s[0].equals("pop_front")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deque.pollFirst()).append("\n");
				}
			}else if(s[0].equals("pop_back")){
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deque.pollLast()).append("\n");
				}
			}else if(s[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			}else if(s[0].equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(s[0].equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deque.peekFirst()).append("\n");
				}
			}else if(s[0].equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deque.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}