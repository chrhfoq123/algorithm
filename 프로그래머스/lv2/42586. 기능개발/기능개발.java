import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQ = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                dayQ.add((100 - progresses[i]) / speeds[i]);
            }else{
                dayQ.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        int q = dayQ.poll();
        int count = 1;
        while(!dayQ.isEmpty()){
            if(q >= dayQ.peek()){
                count++;
                dayQ.poll();
            }else{
                list.add(count);
                count = 1;
                q = dayQ.poll();
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}