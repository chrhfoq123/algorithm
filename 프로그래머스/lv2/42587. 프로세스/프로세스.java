import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
        }
        
        while(!queue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == queue.peek()){
                    if(i == location){
                        answer++;
                        return answer;
                    }else{
                        queue.poll();
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}