import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/***
 * 계속 진행하는 문제에는 Scanner의 hasNextInt(), nextInt()를 사용해야한다.
 */

public class Main {

  static BigInteger[] arr = new BigInteger[251];

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    arr[0] = new BigInteger("1");
    arr[1] = new BigInteger("1");
    arr[2] = new BigInteger("3");
    for (int i = 3; i <= 250; i++) {
      arr[i] = arr[i - 1].add(arr[i - 2].multiply(new BigInteger("2")));
    }
    while (sc.hasNextInt()) {
      int n = sc.nextInt();
      System.out.println(arr[n]);
    }
  }
}