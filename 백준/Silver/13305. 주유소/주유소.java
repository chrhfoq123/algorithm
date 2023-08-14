import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] km = new int[N-1];
        int[] l = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<km.length; i++){
            km[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<l.length; i++){
            l[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int min = l[0];
        for(int i=0; i<km.length; i++){
            if(min > l[i]){
                min = l[i];
            }
            sum += (min * km[i]);
        }
        
        System.out.println(sum);
    }
}