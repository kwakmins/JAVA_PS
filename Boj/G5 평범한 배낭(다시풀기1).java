import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0}); // 순서 맞추기 위함

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            int W = Integer.parseInt(line[0]);
            int V = Integer.parseInt(line[1]);

            list.add(new int[]{W, V});
        }

        // [물건 번호(처음부터 마지막까지 탐색)][무게]
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                int[] x = list.get(i);

                if (j >= x[0]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - x[0]] + x[1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}

