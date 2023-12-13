import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * S2 촌수계산 - https://www.acmicpc.net/problem/2644
 * dfs(노드) - 노드 사이 간선 수 구하기.
 */
public class Main {

  static int n, m, answer = 0;
  static List<Integer>[] list;
  static int[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    String[] line = bf.readLine().split(" ");
    int a = Integer.parseInt(line[0]);
    int b = Integer.parseInt(line[1]);
    m = Integer.parseInt(bf.readLine());
    list = new List[n + 1];
    visit = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      line = bf.readLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int y = Integer.parseInt(line[1]);
      list[x].add(y);
      list[y].add(x);
    }

    dfs(a, 0, b);
    if (answer == 0) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
  }

  static void dfs(int x, int cnt, int y) {
    visit[x] = 1;
    if (x == y) {
      answer = cnt;
      return;
    }
    for (int i : list[x]) {
      if (visit[i] == 0) {
        dfs(i, cnt + 1, y);
      }
    }
  }
}
