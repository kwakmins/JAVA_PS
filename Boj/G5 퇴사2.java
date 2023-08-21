import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 시간 빡빡함
 * 1부터 순서대로 하려는 습관이 있음
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[][] arr = new int[n + 2][2];
    for (int i = 1; i <= n; i++) {
      String[] line = bf.readLine().split(" ");
      arr[i][0] = Integer.parseInt(line[0]);
      arr[i][1] = Integer.parseInt(line[1]);
    }

    int[] dp = new int[n + 2];
    int max = -1;
    for (int i = 1; i <= n + 1; i++) {
      max = Math.max(max, dp[i]);

      int day = i + arr[i][0];
      if (day < n + 2) {
        dp[day] = Math.max(dp[day], max + arr[i][1]);
      }
    }

//    시간 초과
//    for (int i = 2; i <= n; i++) {
//      for (int j = 1; j < i; j++) {
//        if (i - j >= arr[j][0]) {
//          dp[i] = Math.max(dp[j], dp[i]);
//        }
//      }
//      if (n - i >= arr[i][0] - 1) {
//        dp[i] += arr[i][1];
//      }
//    }

    System.out.println(dp[n + 1]);
  }
}
