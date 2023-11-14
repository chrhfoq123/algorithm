import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] km = new long[N-1];
        long[] l = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<km.length; i++){
            km[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<l.length; i++){
            l[i] = Long.parseLong(st.nextToken());
        }
        
        long sum = 0;
        long min = l[0];
        for(int i=0; i<km.length; i++){
            if(min > l[i]){
                min = l[i];
            }
            sum += (min * km[i]);
        }
        
        System.out.println(sum);
    }
}