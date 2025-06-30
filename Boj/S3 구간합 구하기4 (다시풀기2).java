import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]);

            System.out.println(dp[to] - dp[from]);
        }
    }

}



