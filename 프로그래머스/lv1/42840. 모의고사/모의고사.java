import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        
        for(int i=0; i<answers.length; i++){
            if(one[i%one.length] == answers[i]) score[0]++;
            if(two[i%two.length] == answers[i]) score[1]++;
            if(three[i%three.length] == answers[i]) score[2]++;
        }
        
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        if(max == score[0]) list.add(1);
        if(max == score[1]) list.add(2);
        if(max == score[2]) list.add(3);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}