import java.util.*;

class Point{
    int r,c,distance;
    public Point(int r, int c, int distance){
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}

class Solution {
    
    static int[] dr= {-1,1,0,0}, dc={0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer;
        
        answer = bfs(maps);
        return answer;
    }
    
    int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<Point> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new Point(0,0,1));
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if(cur.r == n-1 && cur.c == m-1) {
                return cur.distance;
            }
            
            for(int k=0; k<4; k++) {
                int nr = cur.r+dr[k];
                int nc = cur.c+dc[k];
                
                if(nr>=0&&nc>=0&&nr<n&&nc<m) {
                    if(!visited[nr][nc] && maps[nr][nc]==1) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr,nc,cur.distance+1));
                    }
                }
            }
            
        }
        return -1;
        
    }
}