import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int n, int m, int depth){
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=1; i<=n; i++){
            arr[depth] = i;
            dfs(n, m, depth+1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        dfs(n, m, 0);
        System.out.print(sb);
    }
}
