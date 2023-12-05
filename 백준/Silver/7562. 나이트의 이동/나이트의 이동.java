import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int l;
	public static int nextX;
	public static int nextY;
	public static int[][] board;
	public static int[][] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean inRange(int x, int y) {
		return (x >= 0 && x < l && y >= 0 && y < l);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = 1;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0; i<8; i++) {
				int nx= 0;
				int ny = 0;
				if(i == 0) {
					nx = tmp[0]-2;
					ny = tmp[1]+1;
				}else if(i==1) {
					nx = tmp[0]-1;
					ny = tmp[1]+2;
				}else if(i==2) {
					nx = tmp[0]+2;
					ny = tmp[1]+1;
				}else if(i==3) {
					nx = tmp[0]+1;
					ny = tmp[1]+2;
				}else if(i==4) {
					nx = tmp[0]-2;
					ny = tmp[1]-1;
				}else if(i==5) {
					nx = tmp[0]-1;
					ny = tmp[1]-2;
				}else if(i==6) {
					nx = tmp[0]+1;
					ny = tmp[1]-2;
				}else if(i==7) {
					nx = tmp[0]+2;
					ny = tmp[1]-1;
				}
				
				if(nextX == nx && nextY == ny) {
					sb.append(visited[tmp[0]][tmp[1]]).append("\n");
					return;
				}
				
				if(inRange(nx, ny) && visited[nx][ny] == 0) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = visited[tmp[0]][tmp[1]] +1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			l = Integer.parseInt(br.readLine());
			board = new int[l][l];
			visited = new int[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			nextX = Integer.parseInt(st.nextToken());
			nextY = Integer.parseInt(st.nextToken());
			
			if(nowX == nextX && nowY == nextY) {
				sb.append(0).append("\n");
			}else {
				bfs(nowX, nowY);
			}
		}
		
		System.out.println(sb);
	}
}