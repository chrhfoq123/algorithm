import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0; i<n; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        
        for(int num : arr){
            System.out.println(num);
        }
    }
}