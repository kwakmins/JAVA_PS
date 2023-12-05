import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S1 양팔저울 - https://www.acmicpc.net/problem/17610
 * 완전탐색(부분탐색) - 가진 추로 잴 수 있는 모든 무게 구하기.
 *
 * 모든 추를 안놓기,반대편에 놓기, 놓기 3가지로 부분 탐색
 *
 * @!!! 문제의 예제를 직접 한번 해보자
 * @!!! 부분탐색 이해도 부족
 */
public class Main {

  static int k, s, answer = 0;
  static int[] arr, visit;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(bf.readLine());
    arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);
    s = Arrays.stream(arr).sum();
    visit = new int[s + 1];
    dfs(0, 0);
    System.out.println(s - answer);
  }

  static void dfs(int sum, int idx) {
    if (idx == k && sum > 0) {
      if (visit[sum] == 0) {
        visit[sum] = 1;
        answer++;
      }
      return;
    }

    if (idx < k) {
      dfs(sum, idx + 1);
      dfs(sum + arr[idx], idx + 1);
      dfs(sum - arr[idx], idx + 1);
    }
  }
}
//    시간 초과 (잘못된 부분탐색 구현)
//    dfs(0, 0);
//
//    System.out.println(s - answer);
//  }
//
//  static void dfs(int start, int sum) {
//    dfs2(0, sum);
//
//    for (int i = start; i < k; i++) {
//      if (visit[i] == 0) {
//        visit[i] = 1;
//        dfs(i, sum + arr[i]);
//        visit[i] = 0;
//      }
//    }
//  }
//
//  static void dfs2(int sum, int sum2) {
//    int a = sum2 - sum;
//    if (a > 0 && visit2[a] == 0) {
//      visit2[a] = 1;
//      answer++;
//    }
//
//    for (int i = 0; i < k; i++) {
//      if (visit[i] == 0) {
//        visit[i] = 1;
//        dfs2(sum + arr[i], sum2);
//        visit[i] = 0;
//      }
//    }
//  }
//}
