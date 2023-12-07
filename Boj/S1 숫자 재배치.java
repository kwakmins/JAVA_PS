import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 숫자 재배치 - https://www.acmicpc.net/problem/16943
 * 백트래킹 - B보다 작은 A로 구성된 숫자 중 가장 큰 수 구하기.
 *
 * 중복없는 순열로, B보다 작고 앞이 0으로 시작되지 않는 수 구하기.
 *
 * @@@ dfs를 할 때, 조건이 만족하기 전에, if 처리를 하면 더 빠를듯!
 */
public class Main {

  static String A;
  static int B, C = -1;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    A = line[0];
    B = Integer.parseInt(line[1]);
    visit = new boolean[A.length()];

    dfs("", 0);
    System.out.println(C);
  }

  static void dfs(String s, int deep) {
    if (deep == A.length()) {
      if (s.charAt(0) != '0') { // 밑에서 해주는게 좋음
        int a = Integer.parseInt(s);
        if (a < B) {
          C = Math.max(C, a);
        }
      }
      return;
    }

    for (int i = 0; i < A.length(); i++) {
      if (!visit[i]) {
        visit[i] = true;
        dfs(s + A.charAt(i), deep + 1);
        visit[i] = false;
      }
    }
  }
}
