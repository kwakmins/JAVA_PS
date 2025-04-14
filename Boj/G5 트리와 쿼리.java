import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int Q = Integer.parseInt(s[2]);

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] line = br.readLine().split(" ");

            int U = Integer.parseInt(line[0]);
            int V = Integer.parseInt(line[1]);

            tree[U].add(V);
            tree[V].add(U);
        }

        // 루트를 실행해서 값을 다 만들기 vs dp로 하면서 만들기 (더 편해보임 (재귀를 void로 둘 수 있음)))

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
        }

        dfs(R, R);

        for (int i = 0; i < Q; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(dp[a]);
        }

    }

    static void dfs(int index, int parent) {

        for (int a : tree[index]) {
            if (a == parent) {
                continue;
            }

            dfs(a, index);

            dp[index] += dp[a];
        }

    }

}