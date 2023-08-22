import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * BFS 대표문제 - cnt 없이 arr에 직접 넣어도 됨
 */
public class Main {

  static int[][] arr;
  static int n, m;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] tempLine = bf.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(tempLine[j]);
      }
    }
    Queue<int[]> q = new LinkedList<>();
    int[][] visit = new int[n][m];
    visit[0][0] = 1;
    q.add(new int[]{0, 0, 1});
    while (!q.isEmpty()) {
      int qx = q.peek()[0];
      int qy = q.peek()[1];
      int cnt = q.peek()[2];
      q.poll();
      for (int i = 0; i < 4; i++) {
        int ax = dx[i] + qx;
        int ay = dy[i] + qy;
        if (ax >= 0 && ay >= 0 && ax < m && ay < n && arr[ay][ax] == 1 && visit[ay][ax] == 0) {
          if (ax == m - 1 && ay == n - 1) {
            System.out.println(cnt + 1);
            return;
          }
          q.add(new int[]{ax, ay, cnt + 1});
          visit[ay][ax] = 1;
        }
      }
    }
  }
}
