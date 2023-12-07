import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 부분수열의 합 - https://www.acmicpc.net/problem/14225
 * 백트래킹 - 숫자의 부분수열의 합이 아닌 가장 작은 정수 구하기
 *
 * 숫자를 배열로 나눠 부분집합 구한 후 visit 처리. visit 처리 안된 가장 작은 수 찾기. (N=20이므로 부분집합 OK)
 */
public class Main {

  static boolean[] visit;
  static int[] arr;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    arr = new int[N];
    String[] line = bf.readLine().split(" ");
    for (int i = 0; i < line.length; i++) {
      arr[i] = Integer.parseInt(line[i]);
    }
    visit = new boolean[2000001];
    dfs(0, 0);

    int answer = 0;
    for (int i = 1; i < visit.length; i++) {
      if (!visit[i]) {
        answer = i;
        break;
      }
    }
    System.out.println(answer);

  }

  static void dfs(int sum, int deep) {
    if (deep == N) {
      visit[sum] = true;
      return;
    }

    dfs(sum + arr[deep], deep + 1);
    dfs(sum, deep + 1);
  }
}
