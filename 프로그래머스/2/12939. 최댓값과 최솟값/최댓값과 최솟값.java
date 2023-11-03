import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numStr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<numStr.length; i++){
            int num = Integer.parseInt(numStr[i]);
            
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}