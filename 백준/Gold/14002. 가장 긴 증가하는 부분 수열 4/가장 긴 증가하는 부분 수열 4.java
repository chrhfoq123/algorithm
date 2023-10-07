import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++){
            A[i] = sc.nextInt();
        }
        
        int max = 0;
        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        
        Stack<Integer> stack = new Stack<>();
        for(int i=n; i>=1; i--){
            if(dp[i] == max){
                stack.push(A[i]);
                max--;
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        
        System.out.print(sb);
    }
}