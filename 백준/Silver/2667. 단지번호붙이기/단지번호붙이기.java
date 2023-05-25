import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static boolean[][] visited;
	static int[][] adjArray;
	static int[] dirX = {0, 0, 1, -1 };
	static int[] dirY = {1, -1, 0, 0 };
	static int N;
	static int danjiCount;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N][N];
		adjArray = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<data.length(); j++) {
				adjArray[i][j] = data.charAt(j)-'0';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> danji = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(adjArray[i][j] == 1 && !visited[i][j]) {
					danjiCount = 0;
					dfs(i, j);
					danji.add(danjiCount);
				}
			}
		}
		
		sb.append(danji.size()).append("\n");
		Collections.sort(danji);
		
		for(int i=0; i<danji.size(); i++) {
			sb.append(danji.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		danjiCount++;
		
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