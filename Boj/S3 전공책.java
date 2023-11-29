import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @S3 전공책 - https://www.acmicpc.net/problem/16508
 * 백트래킹 - 책의 제목을 오려 특정 단어로 만들 때, 책의 최소 비용 구하기
 *
 * 알파벳을 배열로 저장해, 특정 단어를 만들 수 있는지 확인하며 백트래킹.
 * @!!! 백트래킹 포함 여부 판단 dfs(idx+1, 포함 O) + dfs(idx+1, 포함 X)
 * @!!! 여부를 판단하는 문제에, 정확하게 만드는데 집중X
 */
public class Main {

  static String T;
  static int N, minSum;
  static String[] books;
  static int[] costs, tAlpha = new int[26], tempAlpha = new int[26];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    T = bf.readLine();
    for (int i = 0; i < T.length(); i++) {
      tAlpha[T.charAt(i) - 'A']++;
    }
    N = Integer.parseInt(bf.readLine());
    books = new String[N];
    costs = new int[N];
    minSum = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      String[] line = bf.readLine().split(" ");
      costs[i] = Integer.parseInt(line[0]);
      books[i] = line[1];
    }
    dfs(0, 0);

    if (minSum == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(minSum);
    }
  }

  static void dfs(int idx, int cost) {
    if (idx == N) {
      if (check()) {
        minSum = Math.min(cost, minSum);
      }
      return;
    }

    String s = books[idx];
    for (int j = 0; j < s.length(); j++) {
      tempAlpha[s.charAt(j) - 'A']++;
    }
    dfs(idx + 1, cost + costs[idx]);
    for (int j = 0; j < s.length(); j++) {
      tempAlpha[s.charAt(j) - 'A']--;
    }
    dfs(idx + 1, cost);

  }

  static boolean check() {
    for (int i = 0; i < 26; i++) {
      if (tAlpha[i] > tempAlpha[i]) {
        return false;
      }
    }
    return true;
  }
}
