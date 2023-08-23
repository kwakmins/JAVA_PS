import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/***
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int m = Integer.parseInt(bf.readLine());
    int[][] arr = new int[n + 1][n + 1];
    int[] visit = new int[n + 1];
    int sum = 0;
    for (int i = 0; i < m; i++) {
      String[] line = bf.readLine().split(" ");
      arr[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
      arr[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
    }
    int ans = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 0});
    visit[1] = 1;
    while (!q.isEmpty()) {
      int x = q.peek()[0];
      int deep = q.peek()[1];
      q.poll();
      if (deep >= 2) {
        continue;
      }
      for (int i = 1; i <= n; i++) {
        if (arr[x][i] == 1 && visit[i] == 0) {
          visit[i] = 1;
          q.add(new int[]{i, deep + 1});
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
