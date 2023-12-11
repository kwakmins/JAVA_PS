import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S2 영재의 시험 - https://www.acmicpc.net/problem/19949
 * 백트래킹 - 10문제의 정답을 찍을 때, 3연속 같은 번호는 찍지 못할 때 5점 이상 맞을 경우의 수 구하기.
 *
 * 모든 찍는 경우의 수에 5점 이상인 수 구하기. (1~9의 12승 이상만 아니면 완탐 가능)
 */
public class Main {

  static int[] arr;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    dfs(0, 0, 0, 0);

    System.out.println(answer);
  }

  static void dfs(int deep, int prev1, int prev2, int score) {

    if (deep == 10) {
      if (score >= 5) {
        answer++;
      }
      return;
    }

    for (int j = 1; j <= 5; j++) {
      if (prev1 == prev2 && prev2 == j) {
        continue;
      }

      if (arr[deep] == j) {
        dfs(deep + 1, prev2, j, score + 1);
      } else {
        dfs(deep + 1, prev2, j, score);
      }
    }

  }
}
