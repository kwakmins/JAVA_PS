import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 *  순열이 아닌 조합일 땐, (반대인 경우가 같음)
 *  i=idx로 해서 가지치기를 수행하여 시간을 절약
 */
public class Main {

  static int min = 123456, n;
  static int[] visit;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    visit = new int[n];
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);
    System.out.println(min);
  }

  static void dfs(int index, int dep) {
    if (dep == n / 2) {
      int start = 0;
      int link = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (visit[i] == 0 && visit[j] == 0) {
            start += board[i][j] + board[j][i];
          } else if (visit[i] == 1 && visit[j] == 1) {
            link += board[i][j] + board[j][i];
          }
        }
      }
      min = Math.min(Math.abs(start - link), min);
      if (min == 0) {
        System.out.println(0);
        System.exit(0);
      }
      return;
    }

    for (int i = index; i < n; i++) {
      if (visit[i] == 0) { // 없어도 됨
        visit[i] = 1;
        dfs(i + 1, dep + 1);
        visit[i] = 0;
      }
    }
  }
}
