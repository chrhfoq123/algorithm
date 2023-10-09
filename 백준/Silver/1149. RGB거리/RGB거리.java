import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[][] dp = new int[n+1][3];

    	for(int i=1; i<=n; i++) {
    		int r = sc.nextInt();
    		int g = sc.nextInt();
    		int b = sc.nextInt();
    		
    		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
    		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
    	}
    	
    	System.out.print(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}