import java.io.*;
import java.util.*;

public class Main {

    static int n,m,v;
    static List<Integer>[] nums;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        nums = new List[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());
            nums[to].add(from);
            nums[from].add(to);
        }
        //nums sort
        for (int i = 1; i <= n; i++) {
            Collections.sort(nums[i]);
        }

        visited = new boolean[n+1];
        visited[v] = true;
        sb.append(v).append(" ");
        dfs(v,1);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int cur, int depth) {
        for (int next: nums[cur]) {
            if(!visited[next]) {
                visited[next] = true;
                sb.append(next).append(" ");
                dfs(next, depth+1);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int next: nums[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);

                }
            }
        }

    }
}
