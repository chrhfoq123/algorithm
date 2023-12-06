import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    
    public static int n;
	public static int m;
	public static int[][] chest;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static Queue<int[]> queue = new LinkedList<>();
    
    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    public static int bfs(){
        while(!queue.isEmpty()){
            int[] item = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = item[0] + dx[i];
                int ny = item[1] + dy[i];
                if(inRange(nx, ny) && chest[nx][ny] == 0){
                    queue.offer(new int[] {nx, ny});
                    chest[nx][ny] = chest[item[0]][item[1]]+1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        if(check()){
            return -1;
        }else{
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(max < chest[i][j]){
                        max = chest[i][j];
                    }
                }
            }
            
            return max - 1;
        }
    }
    
    public static boolean check(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(chest[i][j] == 0){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
        
        chest = new int[n][m];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                chest[i][j] = Integer.parseInt(st.nextToken());
                if(chest[i][j] == 1){
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        System.out.println(bfs());
    }
}