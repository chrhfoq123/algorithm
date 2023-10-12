import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<T; i++) {
    		int n = sc.nextInt();
    		int[][] arr = new int[2][n+1];
    		int[][] dp = new int[2][n+1];
    		
    		for(int j=0; j<2; j++) {
    			for(int k=1; k<=n; k++) {
    				arr[j][k] = sc.nextInt();
    			}
    		}
    		
    		dp[0][1] = arr[0][1];
    		dp[1][1] = arr[1][1];
    		for(int j=2; j<=n; j++) {
    			dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
    			dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
    		}
    		
    		sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
    	}
    	
    	System.out.print(sb);
    }
}