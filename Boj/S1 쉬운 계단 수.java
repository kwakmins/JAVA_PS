import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 2차 배열 DP
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    long[][] dp = new long[n + 1][10];
    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < 10; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j + 1];
        } else if (j == 9) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
        }
      }
    }
    System.out.println(Arrays.stream(dp[n]).sum() % 1000000000);
  }
}
