import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes){
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 1) + 1);
        }
        
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        
        return answer-1;
    }
}