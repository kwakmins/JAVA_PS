import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * S1 부등호 - https://www.acmicpc.net/problem/2529
 * 백트래킹 - 부등호로 이뤄진 board에 만족하는 중복 허용 X 인 최대값 최솟값 구하기
 *
 * 이전 수를 기억해 부등호에 맞는지 확인하며 완전탐색.
 * - 문자열 최대 최소는 귀찮으니까 sort로 하는게 좋을 수 있음
 */
public class Main {

  static int k;
  static String max = "0", min = "99999999999"; // sort 로 구해도 됨!
  static String[] board;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(bf.readLine());
    board = bf.readLine().split(" ");

    visit = new boolean[10];
    for (int i = 0; i < 10; i++) {
      visit[i] = true;
      dfs(0, i + "", i);
      visit[i] = false;
    }
    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(int deep, String sum, int prevNum) {
    if (deep == k) {
      max = max.compareTo(sum) > 0 ? max : sum;
      min = min.compareTo(sum) < 0 ? min : sum;
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (!visit[i]) {
        if (board[deep].equals("<")) {
          if (prevNum < i) {
            visit[i] = true;
            dfs(deep + 1, sum + i, i);
            visit[i] = false;
          }
        } else if (board[deep].equals(">")) {
          if (prevNum > i) {
            visit[i] = true;
            dfs(deep + 1, sum + i, i);
            visit[i] = false;
          }
        }
      }
    }
  }
}
