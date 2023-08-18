import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/***
 * 유명한 문제라 S1인듯
 */
public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    BigInteger k = new BigInteger("2");
    sb.append(k.pow(n).subtract(new BigInteger("1")));
    if (n <= 20) {
      sb.append("\n");
      hanoi(n, 1, 3);
    }
    System.out.println(sb);
  }

  public static void hanoi(int n, int start, int end) {
    if (n == 0) {
      return;
    }
    hanoi(n - 1, start, 6 - start - end);
    sb.append(start).append(" ").append(end).append("\n");
    hanoi(n - 1, 6 - start - end, end);
  }
}
