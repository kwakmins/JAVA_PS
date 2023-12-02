import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * S3 퇴사 - https://www.acmicpc.net/problem/14501
 * 완전탐색(dp가능) - 특정 기간 동안 날짜 단위로 걸리는 일의 가장 큰 금액 구하기.
 *
 * 모든 경우의 수 탐색 -> 가능한 날짜이면 최대값 최산화
 */
public class Main {

  static int n, max = 0;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    board = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] line = bf.readLine().split(" ");
      board[i][0] = Integer.parseInt(line[0]);
      board[i][1] = Integer.parseInt(line[1]);
    }
    dfs(0, 0);
    System.out.println(max);
  }

  static void dfs(int day, int sum) {
    if (day > n) {
      return;
    }

    max = Math.max(max, sum);
    for (int i = day; i < n; i++) {
      dfs(board[i][0] + i, sum + board[i][1]);
    }
  }
}
/**
 * DP 방식
 */
//    int[] dp = new int[n + 1];
//    int max = 0;
//    for (int i = 0; i < n + 1; i++) {
//      max = Math.max(max, dp[i]);
//      int day = i + board[i][0];
//      if (day < n + 1) {
//        dp[day] = Math.max(max + board[i][1], dp[day]);
//      }
//    }
//    System.out.println(dp[n]);
//  }
//}

