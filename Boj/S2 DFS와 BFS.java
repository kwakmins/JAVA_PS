import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/***
 *
 */
public class Main {

  static int n;
  static int[][] arr;
  static Set<Integer> set;
  static Queue<Integer> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int v = Integer.parseInt(line[2]);
    arr = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      String[] tempLine = bf.readLine().split(" ");
      arr[Integer.parseInt(tempLine[0])][Integer.parseInt(tempLine[1])] = 1;
      arr[Integer.parseInt(tempLine[1])][Integer.parseInt(tempLine[0])] = 1;
    }
    set = new LinkedHashSet<>();
    dfs(v);
    for (int i : set) {
      System.out.print(i + " ");
    }
    System.out.println();
    set.clear();

    queue = new LinkedList<>();
    queue.add(v);
    set.add(v);
    while (!queue.isEmpty()) {
      int x = queue.poll();
      if (set.size() == n) {
        break;
      }
      for (int i = 1; i <= n; i++) {
        if (arr[x][i] == 1 && !set.contains(i)) {
          queue.add(i);
          set.add(i);
        }
      }
    }
    for (int i : set) {
      System.out.print(i + " ");
    }
  }

  static void dfs(int x) {
    set.add(x);
    if (set.size() == n) {
      return;
    }
    for (int j = 1; j <= n; j++) {
      if (arr[x][j] == 1 && !set.contains(j)) {
        dfs(j);
      }
    }
  }
}
