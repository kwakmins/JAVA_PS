import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 나무꾼 이다솜 - https://www.acmicpc.net/problem/1421
 * 구현(완전탐색) - 같은 단위로만 팔 수 있는 나무에 자르는 비용이 들 때, 얻을 수 있는 최대 금액 구하기.
 *
 * 모든 길이로 잘라 본 후 최대 금액 구하기. / 50*1000 = 완탐 가능.
 * 딱 맞게 자르면 -1 되는걸 주의
 *
 * @!!! 최대값 계산을 잘못해서 int로 하였음.. 최대값 단위가 1인경우 10000 * 10000 * 50
 */
public class Main {

  static int N, C, W;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    C = Integer.parseInt(line[1]);
    W = Integer.parseInt(line[2]);
    arr = new int[N];

    int max = 0;
    int answer = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
      max = Math.max(max, arr[i]);
    }

    for (int len = 1; len <= max; len++) {
      int tempSum = 0;

      for (int j = 0; j < N; j++) {
        int temp = 0;

        if (arr[j] >= len) {
          if (arr[j] % len == 0) {
            temp = (arr[j] / len) * len * W - (arr[j] / len - 1) * C;
          } else {
            temp = (arr[j] / len) * len * W - (arr[j] / len) * C;
          }
        }

        if (temp > 0) {
          tempSum += temp;
        }
      }

      answer = Math.max(answer, tempSum);
    }

    System.out.println(answer);
  }

}
