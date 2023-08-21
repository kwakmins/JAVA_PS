import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 *
 */

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    int[] dp = new int[41];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < 41; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(bf.readLine());
      if (n < 2) {
        if (n == 0) {
          System.out.println("1 0");
        } else {
          System.out.println("0 1");
        }
      } else {
        System.out.println(dp[n - 2] + " " + dp[n - 1]);
      }
    }
  }
}