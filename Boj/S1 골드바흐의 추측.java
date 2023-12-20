import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 골드바흐의 추측 - https://www.acmicpc.net/problem/6588
 * 에라토스테네스, 수학 - 주어진 수를 두 소수의 합 계산으로 만들 수 있는지 판단.
 *
 * 에라토스테네스로 모든 소수 구한뒤, 10이면 2 8/ 3 7/ 4 6 이런식으로 계산이 되는지 확인.
 */
public class Main {

  static int[] era = new int[1000001];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 2; i <= 1000000; i++) {
      era[i] = i;
    }
    eratos();

    int n = -1;
    while (true) {
      n = Integer.parseInt(bf.readLine());
      if (n == 0) {
        break;
      }
      boolean flag = false;

      for (int i = 2; i <= n / 2; i++) {
        if (era[i] + era[n - i] == n) {
          System.out.println(n + " = " + i + " + " + (n - i));
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.println("Goldbach\'s conjecture is wrong.");
      }

    }
  }

  static void eratos() {

    for (int i = 2; i < Math.sqrt(1000000); i++) {
      if (era[i] != 0) {
        for (int j = i + i; j <= 1000000; j += i) {
          era[j] = 0;
        }
      }
    }
  }
}
