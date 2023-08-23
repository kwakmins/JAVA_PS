import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 *
 */
public class Main {

  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int n, m;
  static String[][] arr;
  static int[][] visit;
  static int max = 0;


  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    arr = new String[n][m];
    for (int i = 0; i < n; i++) {
      String[] tempLine = bf.readLine().split("");
      arr[i] = tempLine;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j].equals("L")) {
          bfs(i, j);
        }
      }
    }
    System.out.println(max);
  }

  static void bfs(int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    visit = new int[n][m];
    q.add(new int[]{y, x, 0});
    visit[y][x] = 1;
    while (!q.isEmpty()) {
      int qx = q.peek()[1];
      int qy = q.peek()[0];
      int cnt = q.peek()[2];
      max = Math.max(max, cnt);
      q.poll();
      for (int i = 0; i < 4; i++) {
        int ax = qx + dx[i];
        int ay = qy + dy[i];
        if (ax >= 0 && ay >= 0 && ax < m && ay < n) {
          if (arr[ay][ax].equals("L") && visit[ay][ax] == 0) {
            q.add(new int[]{ay, ax, cnt + 1});
            visit[ay][ax] = 1;
          }
        }
      }
    }
  }
}
