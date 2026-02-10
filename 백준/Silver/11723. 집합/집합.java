import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int set = 0;
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();


            switch (cmd) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set = set | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set = set & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(((set & (1 << num)) > 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set = set ^ (1 << num);
                    break;
                case "all":
                    set = (1 << 21 ) -1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
