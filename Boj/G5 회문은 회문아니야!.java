import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G5 회문은 회문아니야! - https://www.acmicpc.net/problem/15927
 * 문자열 - 팰린드롬이 아닌 가장 긴 부분문자열 구하기.
 *
 * 팰린드롬은 마지막 하나만 빼도 성립 X
 * 1. 문자열이 팰린드롬이 아니면 문자열 전체 크기 반환
 * 2. 문자열이 팰린드롬이면 문자열 전체 크기 -1 반환
 * 2-2 문자열이 팰린드롬이면서 한글자면 -1 반환
 */
public class Main {

  static int[] era = new int[1000001];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    boolean flag = false;

    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        System.out.println(s.length());
        return;
      }

      if (s.charAt(i) != s.charAt(i + 1)) {
        flag = true;
      }
    }

    if (flag) {
      System.out.println(s.length() - 1);
    } else {
      System.out.println(-1);
    }
  }
}
