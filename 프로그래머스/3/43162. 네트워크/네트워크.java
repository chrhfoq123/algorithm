class Solution {
    
    static boolean[] visited;
    
    static void dfs(int[][] computers, int index, int n){
        visited[index] = true;
        
        for(int i=0; i<n; i++){
            if(visited[i] == false && computers[index][i] == 1){
                dfs(computers, i, n);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                answer++;
                dfs(computers, i, n);
            }
        }
        
        return answer;
    }
}