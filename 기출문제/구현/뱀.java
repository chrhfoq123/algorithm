import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main{
    
    public static int n, k, l;
    public static int[][] board;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0}; //동, 남, 서, 북
    public static HashMap<Integer, String> moveInfo = new HashMap<>();
    public static ArrayList<int[]> snake = new ArrayList<>();
    
    public static boolean inRange(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n){
            return true;
        }
        
        for(int i=0; i<snake.size(); i++){
            int[] cor = snake.get(i);
            if(x == cor[0] && y == cor[1]){
                return true;
            }
        }
        
        return false;
    }
    
    public static void solve(){
        int x = 0, y = 0;
        int time = 0;
        int dir = 0;
        snake.add(new int[] {0, 0});
        
        while(true){
            time++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx, ny)){
                break;
            }
            
            if(board[nx][ny] == 1){
                board[nx][ny] = 0;
                snake.add(new int[] {nx, ny});
            }else{
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }
            
            if(moveInfo.containsKey(time)){
                if(moveInfo.get(time).equals("D")){
                    dir = (dir + 1) % 4;
                }else{
                    dir = (dir + 3) % 4;
                }
            }
            
            x = nx;
            y = ny;
        }
        
        System.out.print(time);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            board[x][y] = 1;
        }
        
        l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            moveInfo.put(time, dir);
        }
        
        solve();
    }
}
