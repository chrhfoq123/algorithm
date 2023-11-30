import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    
    public static int[] visited;
    public static LinkedList<Integer>[] graph;
    public static int count;
    
    public static void dfs(int v){
        visited[v] = count++;
        for(int vertex : graph[v]){
            if(visited[vertex] == 0){
                dfs(vertex);
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
        
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=1; i<=n; i++){
            Collections.sort(graph[i], Comparator.reverseOrder());
        }
        
        count = 1;
        dfs(r);
        
        for(int i=1; i<visited.length; i++){
            System.out.println(visited[i]);
        }
    }
}
