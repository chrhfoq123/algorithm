import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] chess = new String[N];
		
		for(int i=0; i<N; i++) {
			chess[i] = br.readLine();
		}
		
		int max = Integer.MAX_VALUE;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int sol = getSolution(i, j, chess);
				if(max > sol) {
					max = sol;
				}
			}
		}
		System.out.println(max);
	}
	
	static int getSolution(int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
		int whiteSol = 0;
		for(int i=0; i<8; i++) {
			int row = startRow + i;
			for(int j=0; j<8; j++) {
				int col = startCol + j;
				if(board[row].charAt(col) != orgBoard[row%2].charAt(j)) {
					whiteSol++;
				}
			}
		}
		
		return Math.min(whiteSol, 64-whiteSol);
	}
}