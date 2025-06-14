import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] list;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        list = new List[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int x) {

        visit[x] = true;
        dp[x][1] = 1;

        for (int child : list[x]) {

            if (!visit[child]) {
                dfs(child);
                dp[x][0] += dp[child][1];
                dp[x][1] += Math.min(dp[child][1], dp[child][0]);
            }


        }

    }
}

