import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int count;
	public static boolean[] visited;
	public static LinkedList<Integer>[] graph;
	
	public static void dfs(int v) {
		visited[v] = true;
		count++;
		for(int vertex : graph[v]) {
			if(visited[vertex] == false) {
				dfs(vertex);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		count = 0;
		dfs(1);
		
		System.out.print(count-1);
	}
}
