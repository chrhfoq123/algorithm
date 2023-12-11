import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    public static ArrayList<String> list;
    public static boolean[] visited;
    
    //시작 위치, 방문한 여행 경로, tickets, depth
    public static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(list);
        
        answer = list.get(0).split(" ");
        
        return answer;
    }
}