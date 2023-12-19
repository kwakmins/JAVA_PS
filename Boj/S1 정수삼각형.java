import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S1 정수 삼각형 - https://www.acmicpc.net/problem/1932
 * DP - 삼각형 모양에서 대각선 왼쪽 오른쪽에서 내려올 수 있을 때 최대값 구하기.
 *
 * 끝부분이 아닌 부분에서 왼쪽 오른쪽 중 큰쪽에서 내려오게 DP하면됨.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      board[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    int[][] dp = new int[n][n];
    dp[0][0] = board[0][0];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (j == 0) {
          dp[i][j] = board[i][j] + dp[i - 1][j];
          continue;
        }
        if (j == board[i].length - 1) {
          dp[i][j] = board[i][j] + dp[i - 1][j - 1];
          continue;
        }
        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + board[i][j];
      }
    }

    int answer = 0;
    for (int i = 0; i < dp[n - 1].length; i++) {
      answer = Math.max(answer, dp[n - 1][i]);
    }

    System.out.println(answer);
  }
}
