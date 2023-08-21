import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 *
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s))
        .toArray();
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
    }
    System.out.println(Arrays.stream(dp).max().orElseThrow());
  }
}
