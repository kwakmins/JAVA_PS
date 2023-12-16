import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S3 한국이 그리울 땐 서버에 접속하지 - https://www.acmicpc.net/problem/9996
 * 구현 ,문자열 - ${a-z}*${a-z} 패턴이 있을 떄 해당 문자열이 만족하는지 확인.
 *
 * *을 기준으로 앞 뒤로 잘라, 해당 문자열의 앞 뒤가 해당하는지 확인.
 *
 * @!!! 문제의 조건을 입력에서만 찾으려고 했다.. 문제를 잘 보자 (패턴은 알파벳 소문자 여러 개와 *로 이뤄진 문자열)
 */
public class Main {

  static String[] pattern;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    String line = bf.readLine();
    pattern = line.split("\\*");

    for (int i = 0; i < N; i++) {
      String s = bf.readLine();
      System.out.println(checkPattern(s));
    }
  }

  static String checkPattern(String s) {
    if (s.length() < pattern[0].length() + pattern[1].length()) {
      return "NE";
    }
    String s1 = s.substring(0, pattern[0].length());
    String s2 = s.substring(s.length() - pattern[1].length(), s.length());

    if (s1.equals(pattern[0]) && s2.equals(pattern[1])) {
      return "DA";
    }

    return "NE";
  }
}
