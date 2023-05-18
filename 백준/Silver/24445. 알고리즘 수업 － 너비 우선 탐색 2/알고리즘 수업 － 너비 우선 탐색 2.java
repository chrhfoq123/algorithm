import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer>[] graph;
	static int[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[N+1];
		visited = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i], Comparator.reverseOrder());
		}
		
		count = 1;
		bfs(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = count++;
		
		while(!queue.isEmpty()) {
			int vertexItem = queue.poll();
			for(int vertex : graph[vertexItem]) {
				if(visited[vertex] == 0) {
					queue.offer(vertex);
					visited[vertex] = count++;
				}
			}
		}
	}
}