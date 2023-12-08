import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<5; i++) {
			int minIdx = i;
			for(int j=i+1; j<5; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += arr[i];
		}
		
		int answer = arr[2];
		int avg = sum / 5;
		System.out.println(avg);
		System.out.println(answer);
	}
}