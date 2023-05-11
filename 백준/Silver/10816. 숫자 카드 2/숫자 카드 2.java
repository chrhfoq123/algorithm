import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!hashMap.containsKey(num)) {
				hashMap.put(num, 1);
			}else {
				hashMap.put(num, hashMap.get(num)+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			if(hashMap.containsKey(target)) {
				sb.append(hashMap.get(target) + " ");
			}else {
				sb.append(0 + " ");
			}
		}
		
		System.out.print(sb.toString());
	}
}