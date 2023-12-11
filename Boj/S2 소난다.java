import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * S2 소난다 - https://www.acmicpc.net/problem/19699
 * 백트래킹(조합) - N마리 소 중 M마리 선택할 때 나오는 모든 몸무계합 경우의 수 구하기 (소수,오름차순,중복X)
 *
 * 조합으로 모든 경우의 수에 소수 확인 후 TreeSet 저장.
 */
public class Main {

  static int N, M;
  static int[] arr;
  static boolean[] visit;
  static Set<Integer> answer = new TreeSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    visit = new boolean[N];
    arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    dfs(0, 0, 0);

    for (int a : answer) {
      System.out.print(a + " ");
    }
    if (answer.isEmpty()) {
      System.out.println(-1);
    }

  }

  static void dfs(int start, int cnt, int sum) {
    if (cnt == M) {
      if (isPrime(sum)) {
        answer.add(sum);
      }
      return;
    }

    for (int i = start; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        dfs(i, cnt + 1, sum + arr[i]);
        visit[i] = false;
      }
    }
  }

  static boolean isPrime(int x) {
    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }
}
