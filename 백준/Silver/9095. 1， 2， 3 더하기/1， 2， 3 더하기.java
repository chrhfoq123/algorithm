import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j=4; j<=n; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            
            sb.append(dp[n]).append("\n");
        }
        
        System.out.print(sb);
    }
}