import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][3];
        
        dp[0][0] = 1;
        for(int i=1; i<=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
        
        int result = (dp[n][0] + dp[n][1] + dp[n][2]) % 9901;
        System.out.print(result);
    }
}