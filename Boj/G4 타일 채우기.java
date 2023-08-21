import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/***
 *
 */

public class Main {

  static List<BigInteger> list;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    list = new ArrayList<>();
    for (int i = 0; i <= n + 1; i++) {
      list.add(new BigInteger("0"));
    }
    System.out.println(dp(n));
  }

  static BigInteger dp(int x) {
    if (x == 0) {
      return new BigInteger("1");
    }
    if (x == 1) {
      return new BigInteger("0");
    }

    if (x == 2) {
      return new BigInteger("3");
    }
    if (!list.get(x).toString().equals("0")) {
      return list.get(x);
    }
    BigInteger temp = new BigInteger("3").multiply(dp(x - 2));
    for (int i = 3; i <= x; i++) {
      if (i % 2 == 0) {
        temp = temp.add(new BigInteger("2").multiply(dp(x - i)));
      }
    }
    list.set(x, temp);
    return list.get(x);
  }
}