import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static int[][] adjArray;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {-1, 1, 0, 0};
	static int M, N, K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			adjArray = new int[N][M];
			visited = new boolean[N][M];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				adjArray[Y][X] = 1;
			}
			
			int count = 0;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(adjArray[j][k] == 1 && !visited[j][k]) {
						dfs(k, j);
						count++;
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + dirR[i];
			int newY = y + dirC[i];
			
			if(newX>=0 && newY>=0 && newX<M && newY<N) {
				if(adjArray[newY][newX] == 1 && !visited[newY][newX]) {
					dfs(newX, newY);
				}
			}
		}
	}
}