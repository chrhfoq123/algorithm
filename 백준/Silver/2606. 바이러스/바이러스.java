import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[computer+1];
		visited = new boolean[computer+1];
		
		for(int i=1; i<=computer; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			graph[num1].add(num2);
			graph[num2].add(num1);
		}
		
		count = 0;
		bfs(1);
		
		System.out.println(count);
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int vertexItem = queue.poll();
			for(int vertex : graph[vertexItem]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
					count++;
				}
			}
		}
	}
}