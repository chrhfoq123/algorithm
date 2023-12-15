import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            int[] tmp = new int[end-start+1];
            int index = 0;
            for(int j=start-1; j<=end-1; j++){
                tmp[index] = array[j];
                index++;
            }
            
            Arrays.sort(tmp);
            answer[i] = tmp[k-1];
        }
        
        return answer;
    }
}