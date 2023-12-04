import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    
    public static LinkedList<Integer>[] graph;
    public static boolean[] visited;
    
    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        
        for(int vertex : graph[v]){
            if(!visited[vertex]){
                dfs(vertex);
            }
        }
    }
    
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        
        while(!queue.isEmpty()){
            int vertexItem = queue.poll();
            System.out.print(vertexItem + " ");
            for(int vertex : graph[vertexItem]){
                if(!visited[vertex]){
                    queue.offer(vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int vertex = Integer.parseInt(st.nextToken());
        
        graph = new LinkedList[n+1];
        visited = new boolean[n+1];
        
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
            Collections.sort(graph[i]);
        }
        
        dfs(vertex);
        System.out.println();
        visited = new boolean[n+1];
        bfs(vertex);
    }
}
