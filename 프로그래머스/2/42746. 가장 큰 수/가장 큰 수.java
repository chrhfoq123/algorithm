import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        boolean zero = true;
            
        for(int i=0;i <numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0){
                zero = false;
            }
        }
        
        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(int i=0; i<num.length; i++){
            answer += num[i];
        }
        
        if(zero){
            answer = "0";
        }
        
        return answer;
    }
}