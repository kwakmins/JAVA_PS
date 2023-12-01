import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S3 진우 달 여행 - https://www.acmicpc.net/problem/17484
 * 완전탐색 (DP 가능) - 목표 지점까지 한칸 씩 왼쪽 중앙 오른쪽 방식으로 내려갈 수 있을 때 (이전이랑 같은 방식 X), 최소 비용
 *
 * DFS를 하는데, 이전 방식 dx[idx]의 idx를 가지고 함.
 */
public class Main {

  static int N, M, minSum = Integer.MAX_VALUE;
  static int[][] board;
  static int[] dx = {1, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] line2 = bf.readLine().split(" ");
      for (int j = 0; j < line2.length; j++) {
        board[i][j] = Integer.parseInt(line2[j]);
      }
    }

    for (int i = 0; i < M; i++) {
      dfs(i, 0, 5, board[0][i]);
    }

    System.out.println(minSum);
  }

  static void dfs(int idx, int deep, int prev, int sum) {

    if (deep == N - 1) {
      minSum = Math.min(sum, minSum);
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (i == prev) {
        continue;
      }
      int x = idx + dx[i];
      if (x >= 0 && x < M) {
        dfs(x, deep + 1, i, sum + board[deep + 1][x]);
      }
    }
  }
}
