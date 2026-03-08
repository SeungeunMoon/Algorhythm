import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        dist = new int[100001];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        while(!dq.isEmpty()) {

            int cur = dq.poll();

            if(cur==K) break;
            int next = cur * 2;
            if(next < 100001 && dist[next] > dist[cur]) {
                dist[next] = dist[cur];
                dq.addFirst(next);
            }
            next = cur - 1;
            if (next >= 0 && dist[next] > dist[cur]+1) {
                dist[next] = dist[cur]+1;
                dq.addLast(next);
            }
            next = cur + 1;
            if (next < 100001 && dist[next] > dist[cur]+1) {
                dist[next] = dist[cur]+1;
                dq.addLast(next);
            }
        }

        System.out.println(dist[K]);
        
    }




}
