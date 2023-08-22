import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * dp를 풀 때, 모든 경우의 수를 다 보려고함. 최대를 구하는 문제는 최대 구하도록 생각해본다
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
//    틀린 풀이
//    int[][] dp = new int[n + 1][4];
//    dp[1][0] = 1;
//    dp[1][1] = 0;
//    dp[1][2] = 0;
//    dp[1][3] = 0;
//    int max = 1;
//    int temp = 0;
//    boolean b = false;
//    for (int i = 2; i <= n; i++) {
//      dp[i][0] = max + 1;
//      dp[i][1] = max;
//      dp[i][2] = dp[i - 1][1];
//      dp[i][3] = Math.max(max+temp + );
//      max = Math.max(dp[i][0], dp[i][3]);
//    }
//    System.out.println(max);
    long[] dp = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      for (int j = 2; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
      }
    }
    System.out.println(dp[n]);
  }
}
