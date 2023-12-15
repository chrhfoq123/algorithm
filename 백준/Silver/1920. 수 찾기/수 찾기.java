import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean binarySearch(int[] arr, int target, int start, int end) {
		if(start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == target) {
			return true;
		}else if(arr[mid] > target) {
			return binarySearch(arr, target, start, mid-1);
		}else {
			return binarySearch(arr, target, mid+1, end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr1);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(binarySearch(arr1, target, 0, n-1)) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}