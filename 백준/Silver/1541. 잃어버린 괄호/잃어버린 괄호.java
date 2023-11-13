import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
    	
    	int answer = Integer.MAX_VALUE;
    	while(sub.hasMoreTokens()) {
    		int sum = 0;
    		StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
    		
    		while(add.hasMoreTokens()) {
    			sum += Integer.parseInt(add.nextToken());
    		}
    		
    		if(answer == Integer.MAX_VALUE) {
    			answer = sum;
    		}else {
    			answer -= sum;
    		}
    	}
    	
    	System.out.println(answer);
    }
}
