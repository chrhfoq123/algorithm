import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_row = 0;
        int max_col = 0;
        
        for(int i=0; i<sizes.length; i++){
            int row = Math.max(sizes[i][0], sizes[i][1]);
            int col = Math.min(sizes[i][0], sizes[i][1]);
            max_row = Math.max(max_row, row);
            max_col = Math.max(max_col, col);
        }
        
        return max_row * max_col;
    }
}