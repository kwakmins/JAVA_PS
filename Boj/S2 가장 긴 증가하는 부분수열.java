import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * LIS - 조건에 맞는 이전 값 중 가장 큰 값 + 1로 나아가는 DP 방식
 */

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());

    int[] dp = new int[n + 1];
    dp[1] = 1;
    int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int answer = 1;
    for (int i = 1; i < n; i++) {
      dp[i + 1] = 1;
      for (int j = 0; j < i; j++) {
        if (dp[i + 1] <= dp[j + 1] && line[i] > line[j]) {
          dp[i + 1] = dp[j + 1] + 1;
        }
      }
      answer = Math.max(answer, dp[i + 1]);
    }
    System.out.println(answer);
  }
}