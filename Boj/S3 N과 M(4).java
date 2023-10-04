import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 *
 */
public class Main {

  static int N, M;
  static StringBuilder answer;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    answer = new StringBuilder();
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    dfs("", 0, 0);
    System.out.println(answer.toString());
  }

  static void dfs(String s, int dep, int prevNum) {
    if (dep == M) {
      answer.append(s).append("\n");
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (i >= prevNum) {
        dfs(s + i + " ", dep + 1, i);
      }
    }
  }
}
