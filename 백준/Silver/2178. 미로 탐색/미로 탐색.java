import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] adjArray;
	static boolean[][] visited;
	static int[] dirX = {0, 0, 1, -1};
	static int[] dirY = {1, -1, 0, 0};
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjArray = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				adjArray[i][j] = input.charAt(j)-'0';
			}
		}
		
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(adjArray[N-1][M-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int[] nowXY = queue.poll();
			int nowX = nowXY[0];
			int nowY = nowXY[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX - dirX[i];
				int nextY = nowY - dirY[i];
				
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M) {
					if(adjArray[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						queue.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						adjArray[nextX][nextY] = adjArray[nowX][nowY]+1;
					}
				}
			}
		}
	}
}