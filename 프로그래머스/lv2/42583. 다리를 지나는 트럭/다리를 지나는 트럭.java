import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int answer = 0;
        
        for(int i=0; i<truck_weights.length; i++){
            while(true){
                if(queue.isEmpty()){
                    queue.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    answer++;
                    break;
                }else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }else{
                    if(sum + truck_weights[i] > weight){
                        queue.offer(0);
                        answer++;
                    }else{
                        queue.offer(truck_weights[i]);
                        sum += truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}