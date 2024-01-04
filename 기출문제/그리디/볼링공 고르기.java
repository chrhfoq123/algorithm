import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i=0; i<n-1; i++) {
			int num1 = arr[i];
			for(int j=i+1; j<n; j++) {
				int num2 = arr[j];
				if(num1 != num2) {
					cnt++;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
