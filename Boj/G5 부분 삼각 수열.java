import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * G5 부분 삼각 수열 - https://www.acmicpc.net/problem/1548
 * 완전탐색 - 배열에서 숫자를 뽑아 삼각 수열의 최대 길이 구하기.
 *
 * 정렬된 상태에서  '가장 작은 숫자 2개의 합 > 가장 큰 숫자 '를 만족하면 길이 증가.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(arr);

    int answer = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      if (answer + i >= N) {
        break;
      }

      int cnt = 2;
      int sum = arr[i] + arr[i + 1];
      for (int j = i + 2; j < arr.length; j++) {
        if (sum > arr[j]) {
          cnt++;
        } else {
          break;
        }
      }
      answer = Math.max(answer, cnt);
    }

    System.out.println(answer);
  }
}
