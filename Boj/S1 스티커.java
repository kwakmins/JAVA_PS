import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(bf.readLine());
      int[][] arr = new int[n][2];
      String[] s1 = bf.readLine().split(" ");
      for (int i = 0; i < s1.length; i++) {
        arr[i][0] = Integer.parseInt(s1[i]);
      }
      String[] s2 = bf.readLine().split(" ");
      for (int i = 0; i < s1.length; i++) {
        arr[i][1] = Integer.parseInt(s2[i]);
      }

      int[][] dp = new int[n][2];
      dp[0][0] = arr[0][0];
      dp[0][1] = arr[0][1];
      if (n >= 2) {
        dp[1][0] = arr[0][1] + arr[1][0];
        dp[1][1] = arr[0][0] + arr[1][1];
      }
      for (int i = 2; i < n; i++) {
        dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][0];
        dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 2][0], dp[i - 2][1])) + arr[i][1];
      }
      System.out.println(Arrays.stream(dp[n - 1]).max().orElseThrow());
    }
  }
}
