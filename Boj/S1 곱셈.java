import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 곱셈 - https://www.acmicpc.net/problem/1629
 * 분할 정복 - A를 B번 곱한 수를 C로 나눔.
 *
 * 그냥 A를 B번 곱하면 시간초과. (2억 *2억) 따라서 분할 (a)^N/2 * (a)^N/2 = a^N
 * a^N/2을 log로 구함. a^(N/2/2) ... 따라서 시간 초과 X
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] line = bf.readLine().split(" ");
    long A = Long.parseLong(line[0]);
    long B = Long.parseLong(line[1]);
    long C = Long.parseLong(line[2]);

    long answer = pow(A, B, C);
    System.out.println(answer);
  }

  static long pow(long a, long b, long c) {
    if (b == 1) {
      return a % c;
    }

    long temp = pow(a, b / 2, c);

    if (b % 2 == 1) {
      return (temp * temp % c) * a % c;
    }

    return temp * temp % c;
  }
}
