import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @S1 링크와 스타트 - https://www.acmicpc.net/problem/15661
 * 백트래킹 - 두 팀으로 구성할 때, 최소 팀원 격차 값 구하기
 *
 * 모든 팀 구성 탐색 - 한 팀을 visit 하면 다른 팀도 자동 visit.
 * -
 * @!!! 백트래킹의 목표치를 for문으로 모두 정할 수 있음.
 * @!!! boolean[]을 사용하자
 */
public class Main {

  static int answer = Integer.MAX_VALUE, n, t;
  static boolean[] visit;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    visit = new boolean[n];
    board = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] line = bf.readLine().split(" ");

      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(line[j]);
      }
    }
    for (t = 1; t < n; t++) {
      dfs(0, 0);
    }
    System.out.println(answer);
  }

  static void dfs(int start, int cnt) {
    if (cnt == t) {
      int startTeam = 0;
      int linkTeam = 0;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (visit[i] && visit[j]) {
            startTeam += board[i][j] + board[j][i];
          } else if (!visit[i] && !visit[j]) {
            linkTeam += board[i][j] + board[j][i];
          }
        }
      }
      answer = Math.min(Math.abs(startTeam - linkTeam), answer);
      if (answer == 0) {
        System.out.println(answer);
        System.exit(0);
      }
      return;
    }

    for (int i = start; i < n; i++) {
      visit[i] = true;
      dfs(i + 1, cnt + 1);
      visit[i] = false;
    }
  }
}