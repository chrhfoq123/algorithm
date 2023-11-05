class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = 0;
        
        String bin = Integer.toBinaryString(n);
        
        for(int i=0; i<bin.length(); i++){
            if(bin.charAt(i) == '1'){
                oneCnt++;
            }
        }
        
        for(int i=n+1; i<1000000; i++){
            int cnt = 0;
            String bigNBin = Integer.toBinaryString(i);
            for(int j=0; j<bigNBin.length(); j++){
                if(bigNBin.charAt(j) == '1'){
                    cnt++;
                }
            }
            
            if(oneCnt == cnt){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}