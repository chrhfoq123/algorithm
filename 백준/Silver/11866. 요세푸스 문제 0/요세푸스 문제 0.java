import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			int item = queue.poll();
			count++;
			if(count != K) {
				queue.offer(item);
			}else {
				sb.append(item).append(", ");
				count = 0;
			}
		}
		
		int item = queue.poll();
		sb.append(item).append(">");
		System.out.println(sb.toString());
	}
}