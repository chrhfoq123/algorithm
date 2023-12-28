import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dpLR = new int[n];//왼쪽 -> 오른쪽 저장
		int[] dpRL = new int[n]; //오른쪽 -> 왼쪽 저장
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<n; i++){
            dpLR[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
                }
            }
        }
        
        for(int i=n-1; i>=0; i--){
            dpRL[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j]){
                    dpRL[i] = Math.max(dpRL[i], dpRL[j] + 1);
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(dpLR[i] + dpRL[i], max);
        }
        
        //dpRL 과 dpLR을 더했으므로 중복되는 원소가 하나씩 있어서 -1해줘야함
        System.out.print(max-1);
    }
}