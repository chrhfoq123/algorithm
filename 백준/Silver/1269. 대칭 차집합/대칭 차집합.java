import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<a; i++) {
    		int tmp = Integer.parseInt(st.nextToken());
    		map.put(tmp, 1);
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<b; i++) {
    		int tmp = Integer.parseInt(st.nextToken());
    		map.put(tmp, map.getOrDefault(tmp, 0) - 1);
    	}
    	
    	int answer = 0;
    	for(int val : map.values()) {
    		if(val != 0) {
    			answer++;
    		}
    	}
    	
    	System.out.println(answer);
    }
}