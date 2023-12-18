import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	
	public static int binarySearch(int[] arr, int target, int min, int max) {
		int mid = 0;
		
		while(min <= max) {
			long total = 0;
			mid = (min + max) / 2;
			
			for(int num : arr) {
				if(num - mid > 0) {
					total += (num - mid);
				}
			}
			
			if(total < target) {
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		return (max + min) / 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		int result = binarySearch(arr, m, 0, max);
		System.out.println(result);
	}
}