import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	HashSet<Integer> set1 = new HashSet<>();
    	HashSet<Integer> set2 = new HashSet<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<a; i++) {
    		set1.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<b; i++) {
    		set2.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	int answer = 0;
    	for(int num : set1) {
    		if(!set2.contains(num)) {
    			answer+=1;
    		}
    	}
    	
    	for(int num : set2) {
    		if(!set1.contains(num)) {
    			answer+=1;
    		}
    	}
    	
    	System.out.println(answer);
    }
}