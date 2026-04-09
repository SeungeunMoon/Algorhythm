import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] != 0) {
                    int cnt = bfs(i,j);
                    ans.add(cnt);
                }
            }
        }

        System.out.println(ans.size());
        Collections.sort(ans);
        for (Integer an : ans) {
            System.out.println(an);
        }

    }

    static int bfs(int x, int y) {
        int cnt = 0;
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point curr = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dx[i];
                int nc = curr.c + dy[i];

                if(nr>=0 && nc >=0 && nr < n && nc < n) {
                    if(!visited[nr][nc] && grid[nr][nc] != 0) {
                        q.add(new Point(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        return cnt;


    }
}
