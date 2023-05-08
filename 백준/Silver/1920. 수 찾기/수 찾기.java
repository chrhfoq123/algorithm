import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(binary_search(arrN, target, 0, N-1)) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean binary_search(int[] arr, int find, int start, int end) {
		if(start > end) {
			return false;
		}
		int mid = (start + end)/2;
		
		if(arr[mid] == find) {
			return true;
		}else if(arr[mid] > find) {
			return binary_search(arr, find, start, mid-1);
		}else {
			return binary_search(arr, find, mid+1, end);
		}
	}
}