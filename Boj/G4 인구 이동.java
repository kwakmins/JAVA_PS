import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * 로직은 모두 다 맞음 (아슬아슬하게 시간초과 난듯)
 * queue에 Piar 대신 new int[]로 해서 시간초과. - 시간 빡빡하면 Pair 만들기
 * 방문했던 곳 visit2로 저장 해서 시간초과 - List에 또 Pair로 저장해야 했음 int[] 저장하면 visit2보다 더 느림
 */
public class Main {

  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};
  static int n, l, r, ans;
  static int[][] a, visit;
  static boolean flag;

  static class Point {

    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    l = Integer.parseInt(line[1]);
    r = Integer.parseInt(line[2]);
    a = new int[n][n];
    ans = 0;
    for (int i = 0; i < n; i++) {
      a[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    while (true) {
      flag = false;
      visit = new int[n][n];
      ans++;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (visit[i][j] == 0) {
            bfs(j, i);
          }
        }
      }
      if (!flag) {
        ans--;
        break;
      }
    }
    System.out.println(ans);
  }

  static void bfs(int x, int y) {
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(x, y));
    visit[y][x] = 1;
    List<Point> list = new ArrayList<>();
    list.add(new Point(x, y));
    int cnt = 0;
    int sum = 0;

    while (!q.isEmpty()) {
      cnt++;
      Point curPoint = q.peek();
      int qx = curPoint.x;
      int qy = curPoint.y;
      sum += a[qy][qx];
      q.poll();
      for (int i = 0; i < 4; i++) {
        int ax = qx + dx[i];
        int ay = qy + dy[i];
        if (ax >= 0 && ay >= 0 && ax < n && ay < n && visit[ay][ax] == 0) {
          int abs = Math.abs(a[qy][qx] - a[ay][ax]);
          if (abs >= l && abs <= r) {
            q.add(new Point(ax, ay));
            visit[ay][ax] = 1;
            list.add(new Point(ax, ay));
            flag = true;
          }
        }
      }
    }
    if (flag) {
      int result = sum / cnt;
      for (Point p : list) {
        a[p.y][p.x] = result;
      }
    }
  }
}
