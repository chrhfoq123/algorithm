import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            String name = br.readLine();
            map1.put(name, i);
            map2.put(i, name);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String search = br.readLine();
            if(49 <= search.charAt(0) && 57 >= search.charAt(0)){
                sb.append(map2.get(Integer.parseInt(search))).append("\n");
            }else{
                sb.append(map1.get(search)).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}