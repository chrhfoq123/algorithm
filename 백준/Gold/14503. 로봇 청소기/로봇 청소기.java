import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int n;
    public static int m;
    public static int cnt = 1;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    public static void clean(int x, int y, int dir){
        map[x][y] = -1;
        
        for(int i=0; i<4; i++){
            dir = (dir + 3) % 4;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny) && map[nx][ny] == 0){
                clean(nx, ny, dir);
                cnt++;
                return;
            }
        }
        
        int prevDir = (dir + 2) % 4;
        int prevX = x + dx[prevDir];
        int prevY = y + dy[prevDir];
        if(inRange(prevX, prevY) && map[prevX][prevY] != 1){
            clean(prevX, prevY, dir);
        }
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(r, c, d);
        System.out.print(cnt);
    }
}