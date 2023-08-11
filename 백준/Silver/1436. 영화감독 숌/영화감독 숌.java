import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ruin = 666;
        int count = 1;
        
        while(count != N){
            ruin++;
            if(String.valueOf(ruin).contains("666")){
                count++;
            }
        }
        
        System.out.println(ruin);
    }
}