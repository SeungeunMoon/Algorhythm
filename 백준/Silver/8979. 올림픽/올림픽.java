import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] oly = new int[N+1][3];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                oly[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rank = 1;
        for (int i = 1; i < N+1; i++) {
            if(i == K) continue;

            if(oly[i][0] == oly[K][0]) {
                if (oly[i][1] == oly[K][1]) {
                    if(oly[i][2] > oly[K][2]) {
                        rank++;
                    }
                }else if(oly[i][1] > oly[K][1]) {
                    rank++;
                }
            } else if(oly[i][0] > oly[K][0]) {
                rank++;
            }
        }

        System.out.println(rank);
    }
}
