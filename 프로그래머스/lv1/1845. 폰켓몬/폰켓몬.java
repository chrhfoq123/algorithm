import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        int max = nums.length/2;
        
        for(int num : nums){
            hash.add(num);
        }
        
        if(max<hash.size()){
            return max;
        }else{
            return hash.size();
        }
    }
}