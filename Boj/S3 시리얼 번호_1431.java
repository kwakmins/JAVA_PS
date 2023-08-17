import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 *
 */

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    List<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(bf.readLine());
    }

    list.stream()
        .sorted((a, b) -> comp(a, b))
        .forEach(System.out::println);
  }

  public static int comp(String a, String b) {
    if (a.length() == b.length()) {
      int aSum = 0;
      int bSum = 0;
      for (char c : a.toCharArray()) {
        if (c >= '1' && c <= '9') {
          aSum += Integer.parseInt(String.valueOf(c));
        }
      }
      for (char c : b.toCharArray()) {
        if (c >= '1' && c <= '9') {
          bSum += Integer.parseInt(String.valueOf(c));
        }
      }
      if (aSum == bSum) {
        return a.compareTo(b);
      } else {
        return aSum - bSum;
      }
    } else {
      return a.length() - b.length();
    }
  }
}