import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
    public static int getSolution(int startRow, int startCol, String[] board){
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSol = 0;
        
        for(int i=0; i<8; i++){
            int row = startRow + i;
            for(int j=0; j<8; j++){
                int col = startCol + j;
                if(board[row].charAt(col) != orgBoard[row % 2].charAt(j)){
                    whiteSol++;
                }
            }
        }
        
        return Math.min(whiteSol, 64 - whiteSol);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] chess = new String[n];
        
        for(int i=0; i<n; i++){
            chess[i] = br.readLine();
        }
        
        int sol = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int curSol = getSolution(i, j, chess);
                if(sol > curSol){
                    sol = curSol;
                }
            }
        }
        
        System.out.println(sol);
    }
}