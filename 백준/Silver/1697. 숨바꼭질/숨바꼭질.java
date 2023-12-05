import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    
    public static int k;
    public static int[] visited = new int[100001];
    
    public static void bfs(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = 1;
        
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            
            for(int i=0; i<3; i++){
                int next;
                
                if(i == 0){
                    next = tmp + 1;
                }else if(i == 1){
                    next = tmp - 1;
                }else{
                    next = tmp * 2;
                }
                
                if(next == k){
                    System.out.print(visited[tmp]);
                    return;
                }
                
                if(next >= 0 && next < 100001 && visited[next] == 0){
                    queue.offer(next);
                    visited[next] = visited[tmp] + 1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        if(n == k){
            System.out.print(0);
        }else{
            bfs(n);
        }
    }
}