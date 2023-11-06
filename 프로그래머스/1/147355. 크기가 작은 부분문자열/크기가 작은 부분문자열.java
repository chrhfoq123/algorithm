class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long intP = Long.parseLong(p);
        
        for(int i=0; i<t.length()-p.length()+1; i++){
            long intT = Long.parseLong(t.substring(i, i+p.length()));
            if(intT <= intP){
                answer++;
            }
        }
        
        return answer;
    }
}