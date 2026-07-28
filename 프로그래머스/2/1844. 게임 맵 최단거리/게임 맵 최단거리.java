import java.util.*;

class Solution {
    
    class Point {
        int r,c,distance;
        
        public Point(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean[][] visited;
    static int n,m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    public int bfs(int[][] maps) {
        
        Queue<Point> q = new ArrayDeque<>();
        
        q.add(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int d = cur.distance;
            
            if(r == (n-1) && c == (m-1)) return d;
            
            for(int i = 0 ; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr>=0 && nc>=0 && nr<n && nc<m) {
                    if(!visited[nr][nc] && maps[nr][nc] != 0) {
                        q.add(new Point(nr, nc, d+1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1; 
    }
}