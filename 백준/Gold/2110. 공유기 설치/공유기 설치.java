import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	
	public static int binarySearch(int[] arr, int target, int min, int max) {
		int mid = 0;
		
		while(min <= max) {
			int count = 1;
			int prev = arr[0];
			mid = (min + max) / 2;
			
			for(int i=1; i<arr.length; i++) {
				if(arr[i]-prev >= mid) {
					count++;
					prev = arr[i];
				}
			}
			
			if(count < target) {
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		return (min + max) / 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int min = 0;
		int max = arr[n-1] - arr[0]; //최대 간격
		
		int result = binarySearch(arr, c, min, max);
		System.out.println(result);
	}
}