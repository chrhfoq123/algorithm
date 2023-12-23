import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long min = 1;
        long mid = 0;
        long max = (long) times[times.length-1]*n;
        long sum;
        
        while(min <= max){
            sum = 0;
            mid = (min + max) / 2;
            
            for(int time : times){
                sum += (mid / time);
            }
            
            if(sum < n){
                min = mid + 1;
            }else{
                max = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}