import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S2 도영이가 만든 맛있는 음식 - https://www.acmicpc.net/problem/2961
 * 백트래킹 - 재료 Board에 곱연산 신맛과 합연산 쓴맛을 가장 차이가 적게 만들기.
 *
 * 모든 재료를 넣는다,안넣는다 로 간단한 백트래킹
 */
public class Main {

  static int N, answer = Integer.MAX_VALUE;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    board = new int[N][2];
    for (int i = 0; i < N; i++) {
      String[] line = bf.readLine().split(" ");
      int S = Integer.parseInt(line[0]);
      int B = Integer.parseInt(line[1]);
      board[i][0] = S;
      board[i][1] = B;
    }
    dfs(0, 1, 0, 0);

    System.out.println(answer);
  }

  public static void dfs(int deep, int s, int b, int cnt) {
    if (deep == N) {
      if (cnt > 0) {
        answer = Math.min(Math.abs(s - b), answer);
      }
      return;
    }

    dfs(deep + 1, s * board[deep][0], b + board[deep][1], cnt + 1);
    dfs(deep + 1, s, b, cnt);
  }
}
