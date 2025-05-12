import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] tree;
    static int[] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int R = Integer.parseInt(line[1]);
        int Q = Integer.parseInt(line[2]);

        tree = new List[N + 1];
        dp = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(R);

        for (int i = 0; i < Q; i++) {

            System.out.println(dp[Integer.parseInt(br.readLine())]);

        }
    }


    static void dfs(int x) {

        visit[x] = true;

        for (int a : tree[x]) {

            if (!visit[a]) {
                dfs(a);
                dp[x] += dp[a];
            }

        }
        dp[x]++;

    }
}