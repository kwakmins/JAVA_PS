import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * S2 꽃길 https://www.acmicpc.net/problem/14620
 * 백트래킹 - 겹치지 않게 꽃 모양으로 방문할 때, 최소값 구하기
 */
public class Main {

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int[][] visit;
  static int[][] map;
  static int N, answer;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    answer = Integer.MAX_VALUE;
    map = new int[N][N];
    visit = new int[N][N];
    for (int i = 0; i < N; i++) {
      String[] line = bf.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(line[j]);
      }
    }
    dfs(0, 0);

    System.out.println(answer);
  }

  static void dfs(int sum, int cnt) {
    if (cnt == 3) {
      answer = Math.min(answer, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (possible(i, j)) {
          setVisit(i, j, 1);
          dfs(calculateSum(i, j, sum), cnt + 1);
          setVisit(i, j, 0);
        }
      }
    }
  }

  static boolean possible(int x, int y) {
    if (visit[y][x] == 1) {
      return false;
    }
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      if (ax < 0 || ay < 0 || ax >= N || ay >= N) {
        return false;
      }
      if (visit[ay][ax] == 1) {
        return false;
      }
    }
    return true;
  }

  static void setVisit(int x, int y, int value) {
    visit[y][x] = value;
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      visit[ay][ax] = value;
    }
  }

  static int calculateSum(int x, int y, int sum) {
    sum += map[y][x];
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      sum += map[ay][ax];
    }
    return sum;
  }
}
