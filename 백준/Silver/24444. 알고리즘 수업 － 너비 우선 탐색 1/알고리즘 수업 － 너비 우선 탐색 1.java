import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] visited;
	public static LinkedList<Integer>[] graph;
	public static int count;
	
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = count++;
        
        while(!queue.isEmpty()){
            int vertexItem = queue.poll();
            for(int vertex : graph[vertexItem]){
                if(visited[vertex] == 0){
                    visited[vertex] = count++;
                    queue.offer(vertex);
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		graph = new LinkedList[n+1];
		visited = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(graph[i]);
		}
		
		count = 1;
		bfs(r);
		
		for(int i=1; i<visited.length; i++) {
			System.out.println(visited[i]);
		}
	}
}
