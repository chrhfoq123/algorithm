import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			graph[num1].add(num2);
			graph[num2].add(num1);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		sb = new StringBuilder();
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		
		bfs(V);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for(int vertex : graph[v]) {
			if(!visited[vertex]) {
				dfs(vertex);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int vertexItem = queue.poll();
			sb.append(vertexItem + " ");
			for(int vertex : graph[vertexItem]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
}