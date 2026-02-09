import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visit;
    static long result = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        visit = new boolean[N][M];

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int deep) {

        int n = deep / M; // N 실수
        int m = deep % M;

        if (n >= N) { // 완성 후 ++
            result++;
            return;
        }

        if (isPossible(n, m)) {
            visit[n][m] = true;
            dfs(deep + 1);
            visit[n][m] = false;
        }

        dfs(deep + 1);

    }

    static boolean isPossible(int n, int m) {

        if (n - 1 >= 0 && m - 1 >= 0 && visit[n - 1][m - 1] && visit[n][m - 1] && visit[n - 1][m]) {
            return false;
        }

        return true;
    }
}

