class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        //1부터 계속해서 잘라나가는 단위(1~s의 길이 절반까지 자름)
        for(int i=1; i<=s.length()/2; i++){
            String str = "";
            String prev = s.substring(0, i); //단위 만큼 잘라놓은 이전 문자열
            int cnt = 1; //압축 횟수
            //단위 크기만큼 증가시키며 이전 문자열과 비교
            for(int j=i; j<s.length(); j+=i){
                String tmp = "";
                for(int k=j; k<j+i; k++){
                    if(k < s.length()){
                        tmp += s.charAt(k);
                    }
                }
                if(prev.equals(tmp)){
                    cnt++;
                }else{
                    if(cnt >= 2){
                        str += cnt + prev;
                        tmp = "";
                    }else{
                        str += prev;
                        tmp = "";
                    }
                    
                    for(int k=j; k<j+i; k++){
                        if(k < s.length()){
                            tmp += s.charAt(k);
                        }
                    }
                    prev = tmp;
                    cnt = 1;
                }
            }
            
            if(cnt >= 2){
                str += cnt + prev;
            }else{
                str += prev;
            }
            
            answer = Math.min(answer, str.length());
        }
        
        return answer;
    }
}