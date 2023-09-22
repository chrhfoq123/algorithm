import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=n; i++){
            queue.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int count = 0;
        while(queue.size() != 1){
            int item = queue.poll();
            count++;
            if(count != k){
                queue.offer(item);
            }else{
                sb.append(item).append(", ");
                count = 0;
            }
        }
        
        int item = queue.poll();
        sb.append(item).append(">");
        
        System.out.print(sb);
    }
}