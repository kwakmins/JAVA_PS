import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 금민수의 개수 -https://www.acmicpc.net/problem/1527
 * 재귀 - 4와 7로만 이뤄진 수 찾기
 *
 * 재귀로 4와 7로만 이뤄진 수 만들기.
 *
 * @!!! 최대값이 1억이면, long 고려.
 */
public class Main {

  static int a, b, answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    a = Integer.parseInt(line[0]);
    b = Integer.parseInt(line[1]);
    dfs(4);
    dfs(7);
    System.out.println(answer);
  }

  static void dfs(long num) {
    if (num > b) {
      return;
    }
    if (num >= a) {
      answer++;
    }
    dfs(num * 10 + 4);
    dfs(num * 10 + 7);
  }
}
