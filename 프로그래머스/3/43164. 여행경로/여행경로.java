import java.util.*;

class Solution {
    
    List<String> allRoutes = new ArrayList<>();
    boolean[] visited;
    int n;
    
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        n = tickets.length;
        visited = new boolean[n];
        
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        dfs("ICN", "ICN", tickets, 0);
        answer = allRoutes.get(0).split(" ");
        
        return answer;
    }
    
    
    public void dfs(String cur, String route, String[][] tickets, int count) {
        if(count == n) {
            
            allRoutes.add(route);
            
            return;
        }
        
        for(int i = 0; i < n; i++) {
            
            if(!visited[i] && tickets[i][0].equals(cur) ) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}