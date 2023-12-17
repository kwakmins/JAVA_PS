import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * G5 리모컨 - https://www.acmicpc.net/problem/1107
 * 완전탐색 - 0~9까지 숫자와 + - 버튼이 있는 리모컨에 특정 고장난 버튼이 있을 때, 특정 번호로 이동하는 버튼의 최솟값 구하기
 *
 * 처음 100에서 이동하는 경우 계산 과 이동하는 모든 경우의 수 계산의 최솟값 비교
 */
public class Main {

  static int N, M, answer = Integer.MAX_VALUE, len;
  static boolean[] b = new boolean[12];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s1 = bf.readLine();
    len = s1.length();
    N = Integer.parseInt(s1);
    M = Integer.parseInt(bf.readLine());
    if (M > 0) {
      String[] line = bf.readLine().split(" ");
      for (String s : line) {
        if (s.equals("+")) {
          b[10] = true;
          continue;
        }
        if (s.equals("-")) {
          b[11] = true;
          continue;
        }
        b[Integer.parseInt(s)] = true;
      }
    }

    if (!b[10]) {
      if (100 <= N) {
        answer = Math.min(answer, N - 100);
      }
    }
    if (!b[11]) {
      if (100 >= N) {
        answer = Math.min(answer, 100 - N);
      }
    }
    if (answer != 0) {
      dfs(0, 0, 0);
    }
    System.out.println(answer);
  }

  static void dfs(int cnt, int value, int deep) {
    if (deep >= 1) {
      if (deep > len + 1) {
        return;
      }
      if (!b[10]) {
        if (value <= N) {
          answer = Math.min(answer, cnt + N - value);
        }
      }
      if (!b[11]) {
        if (value >= N) {
          answer = Math.min(answer, cnt + value - N);
        }
      }
    }

    for (int i = 0; i < 10; i++) {
      if (!b[i]) {
        dfs(cnt + 1, value * 10 + i, deep + 1);
      }
    }
  }
}
