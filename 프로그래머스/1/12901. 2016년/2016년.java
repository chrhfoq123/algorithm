class Solution {
    public String solution(int a, int b) {
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = 0;
        for(int i=0; i<a-1; i++){
            day += date[i];
        }
        day += b;
        
        return week[(day+4) % 7];
    }
}