import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int n;
    static int m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    
    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] item = queue.poll();
            for(int i=0; i<4; i++){
                int nx = item[0] + dx[i];
                int ny = item[1] + dy[i];
                if(inRange(nx, ny) && board[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    board[nx][ny] = board[item[0]][item[1]] + 1;
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        board = maps;
        visited = new boolean[n][m];
        
        bfs(0, 0);
        if(board[n-1][m-1] == 1){
            return -1;
        }
        
        return board[n-1][m-1];
    }
}