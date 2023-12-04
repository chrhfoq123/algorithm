import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    public static int m;
    public static int n;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && board[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            board = new int[m][n];
            visited = new boolean[m][n];
            
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            
            int count = 0;
            for(int idx1=0; idx1<m; idx1++){
                for(int idx2=0; idx2<n; idx2++){
                    if(board[idx1][idx2] == 1 && !visited[idx1][idx2]){
                        dfs(idx1, idx2);
                        count++;
                    }
                }
            }
            
            sb.append(count).append("\n");            
        }
        
        System.out.println(sb);
    }
}
