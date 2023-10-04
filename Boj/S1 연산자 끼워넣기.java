import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 문제를 잘 읽자..
 */
public class Main {

  static int n, max = -1000000001, min = 1000000001;
  static int[] arr;
  static int[] cals;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
        .toArray();
    cals = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
        .toArray();
    dfs(arr[0], 1);
    System.out.println(max);
    System.out.println(min);
  }

  static void dfs(int sum, int dep) {
    if (dep == n) {
      max = Math.max(sum, max);
      min = Math.min(sum, min);
      return;
    }

    for (int j = 0; j < 4; j++) {
      if (cals[j] > 0) {
        if (j == 0) {
          cals[j]--;
          dfs(sum + arr[dep], dep + 1);
          cals[j]++;
        } else if (j == 1) {
          cals[j]--;
          dfs(sum - arr[dep], dep + 1);
          cals[j]++;
        } else if (j == 2) {
          cals[j]--;
          dfs(sum * arr[dep], dep + 1);
          cals[j]++;
        } else if (j == 3) {
          cals[j]--;
          dfs(sum / arr[dep], dep + 1);
          cals[j]++;
        }
      }
    }
  }
}


