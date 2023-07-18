class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        
        while(i <= n){
            if((i%3==0) || (String.valueOf(i).contains("3"))){
                n++;
            }
            i++;
        }
        
        answer = n;
        return answer;
    }
}