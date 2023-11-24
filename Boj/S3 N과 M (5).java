import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * S3 N과 M (5) - https://www.acmicpc.net/problem/15654
 * 간단한 백트래킹
 *
 */
public class Main {

  static int N, M;
  static int[] visit, arr;
  static StringBuilder answer;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    answer = new StringBuilder();
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);

    visit = new int[N];
    arr = new int[N];
    String[] line2 = bf.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(line2[i]);
    }
    Arrays.sort(arr);

    dfs("", 0);

    System.out.println(answer.toString());
  }

  static void dfs(String s, int cnt) {
    if (cnt == M) {
      answer.append(s).append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visit[i] == 0) {
        visit[i] = 1;
        dfs(s + arr[i] + " ", cnt + 1);
        visit[i] = 0;
      }
    }

  }
}
