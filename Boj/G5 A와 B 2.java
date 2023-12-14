import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @G5 A와 B 2 - https://www.acmicpc.net/problem/12919
 * 완전탐색 - A와 B로만 이뤄진 S와 T 문자열에서 S에서 맨 뒤에 A 추가 OR 맨 뒤에 B 추가 + 뒤집기 할 때, T를 만들 수 있는지 확인
 *
 * S->T로 가는 경우의 수 (2^50)는 불가능. 역순으로 T->S로 가면 경우의 수 많이 줄어듬.
 * .
 * @!!! 문자열은 확장보다 축소하는게 경우의 수가 더 적다
 * @!!! 역으로 한다는 발상을 안해봄...
 */
public class Main {

  static String T, S;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    S = bf.readLine();
    T = bf.readLine();

    dfs(T);
    System.out.println(answer);
  }

  static void dfs(String t) {
    if (answer == 1) {
      return;
    }
    if (t.length() == S.length()) {
      if (t.equals(S)) {
        answer = 1;
      }
      return;
    }

    if (t.charAt(t.length() - 1) == 'A') {
      dfs(t.substring(0, t.length() - 1));
    }

    if (t.charAt(0) == 'B') {
      dfs(new StringBuilder(t.substring(1, t.length())).reverse().toString());
    }
  }
}
