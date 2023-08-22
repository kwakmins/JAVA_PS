import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 * DFS BFS 연습
 */
public class Main {

  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static int[][] arr;
  static int[][] visit;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    for (int tt = 0; tt < t; tt++) {
      String[] line = bf.readLine().split(" ");
      m = Integer.parseInt(line[0]);
      n = Integer.parseInt(line[1]);
      int k = Integer.parseInt(line[2]);
      arr = new int[n][m];
      visit = new int[n][m];
      for (int i = 0; i < k; i++) {
        String[] tempLine = bf.readLine().split(" ");
        arr[Integer.parseInt(tempLine[1])][Integer.parseInt(tempLine[0])] = 1;
      }

      int cnt = 0;
//    BFS 방식
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] == 1) {
            cnt++;
            bfs(j, i);
          }
        }
      }

//    DFS 방식

//      for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//          if (arr[i][j] == 1) {
//            cnt++;
//            dfs(j, i);
//          }
//        }
//      }
      System.out.println(cnt);
    }
  }

  static void dfs(int x, int y) {
    arr[y][x] = 0;
    visit[y][x] = 1;
    for (int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      if (ax >= 0 && ay >= 0 && ax < m && ay < n && arr[ay][ax] == 1 && visit[ay][ax] == 0) {
        dfs(ax, ay);
      }
    }
  }

  static void bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});

    while (!q.isEmpty()) {
      int qx = q.peek()[0];
      int qy = q.peek()[1];
      q.poll();
      arr[qy][qx] = 0;
      visit[qy][qx] = 1;
      for (int i = 0; i < 4; i++) {
        int ax = qx + dx[i];
        int ay = qy + dy[i];
        if (ax >= 0 && ay >= 0 && ax < m && ay < n && arr[ay][ax] == 1 && visit[ay][ax] == 0) {
          q.add(new int[]{ax, ay});
          visit[ay][ax] = 1; //**
        }
      }
    }
  }
}
