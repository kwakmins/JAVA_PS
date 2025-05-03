import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            System.exit(0);
        } else if (N <= 3) {
            System.out.println(1);
            System.exit(0);
        }

        int[] dp = new int[N + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {

            int min = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                min = dp[i / 2] + 1;
            }

            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }

            dp[i] = Math.min(min, dp[i - 1] + 1);
        }

        System.out.println(dp[N]);

    }
}