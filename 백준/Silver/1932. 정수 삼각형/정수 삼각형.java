import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int[][] arr = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(answer < dp[n][i]){
                answer = dp[n][i];
            }
        }
        
        System.out.print(answer);
    }
}