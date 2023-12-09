import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] score = new int[N];
		int tmp = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		System.out.println(score[score.length-k]);
	}
}