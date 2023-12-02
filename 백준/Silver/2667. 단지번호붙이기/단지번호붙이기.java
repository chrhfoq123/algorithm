import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    public static int n;
    public static int count;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static boolean inRange(int x, int y){
        return (x >=0 && x < n && y >= 0 && y < n);
    }
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        count++;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
