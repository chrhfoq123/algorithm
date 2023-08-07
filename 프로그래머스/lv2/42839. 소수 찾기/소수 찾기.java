import java.util.HashSet;
import java.util.Iterator;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        recursive("", numbers);
        
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int num = it.next();
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void recursive(String s, String original){
        if(!s.equals("")){
            set.add(Integer.valueOf(s));
        }
        
        for(int i=0; i<original.length(); i++){
            recursive(s + original.charAt(i), original.substring(0, i) + original.substring(i+1));
        }
    }
    
    public boolean isPrime(int num){
        if(num==0 || num==1){
            return false;
        }
        
        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}