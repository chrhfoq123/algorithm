import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	
	public static long binarySearch(int[] arr, int target, long min, long max) {
		long mid = 0;
		
		while(min <= max) {
			mid = (min + max) / 2;
			long count = 0;
			
			for(long num : arr) {
				count += (num / mid);
			}
			
			if(count < target) {
				max = mid-1;
			}else {
				min = mid+1;
			}
		}
		
		return (max + min) / 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		long max = 0;
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		long result = binarySearch(arr, n, 1, max);
		System.out.println(result);
	}
}