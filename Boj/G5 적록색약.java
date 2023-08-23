import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 *
 */
public class Main {

  static String[][] arr;
  static int n;
  static int[][] visit;
  static int[][] visit2;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    arr = new String[n][n];
    visit = new int[n][n];
    visit2 = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = bf.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = line[j];
      }
    }

    int cnt = 0;
    int cnt2 = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visit[i][j] == 0) {
          dfs(i, j, arr[i][j]);
          cnt++;
        }
        if (visit2[i][j] == 0) {
          dfs2(i, j, arr[i][j].equals("R") ? "G" : arr[i][j]);
          cnt2++;
        }
      }
    }

    System.out.println(cnt + " " + cnt2);
  }

  static void dfs(int y, int x, String color) {
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      if (ax >= 0 && ay >= 0 && ax < n && ay < n && arr[ay][ax].equals(color)
          && visit[ay][ax] == 0) {
        visit[ay][ax] = 1;
        dfs(ay, ax, color);
      }
    }
  }

  static void dfs2(int y, int x, String color) {
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      if (ax >= 0 && ay >= 0 && ax < n && ay < n) {
        String tempColor = arr[ay][ax].equals("R") ? "G" : arr[ay][ax];
        if (tempColor.equals(color) && visit2[ay][ax] == 0) {
          visit2[ay][ax] = 1;
          dfs2(ay, ax, color);
        }
      }
    }
  }
}
