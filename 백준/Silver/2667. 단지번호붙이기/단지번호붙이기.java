import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static boolean[][] visited;
	static int[][] adjArray;
	static int[] dan_g;
	static int[] dirX = {0, 0, 1, -1 };
	static int[] dirY = {1, -1, 0, 0 };
	static int N;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N][N];
		adjArray = new int[N][N];
		dan_g = new int[25*25];
		
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<data.length(); j++) {
				adjArray[i][j] = data.charAt(j)-'0';
			}
		}
		
		count = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(adjArray[i][j] == 1 && !visited[i][j]) {
					count++;
					dfs(i, j);
				}
			}
		}
		
		sb.append(count).append("\n");
		
		Arrays.sort(dan_g);
		
		for(int i=0; i<dan_g.length; i++) {
			if(dan_g[i] != 0) {
				sb.append(dan_g[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		dan_g[count]++;
		
		for(int i=0; i<4; i++) {
			int newX = x + dirX[i];
			int newY = y + dirY[i];
			
			if(newX>=0 && newY>=0 && newX<N && newY<N) {
				if(adjArray[newX][newY] == 1 && !visited[newX][newY]) {
					dfs(newX, newY);
				}
			}
		}
	}
}