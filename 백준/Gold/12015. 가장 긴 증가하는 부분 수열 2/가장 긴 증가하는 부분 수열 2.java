import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		
		for(int num : a) {
			if(num > list.get(list.size()-1)) {
				list.add(num);
			}else {
				int left = 0;
				int right = list.size()-1;
				int mid = 0;
				
				while(left < right) {
					mid = (left + right) / 2;
					if(list.get(mid) < num) {
						left = mid + 1;
					}else {
						right = mid;
					}
				}
				
				list.set(right, num);
			}
		}
		
		System.out.println(list.size()-1);
	}
}