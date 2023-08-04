import java.util.Scanner;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String[] str = Arrays.stream(a.split(""))
        .map(s -> Character.toString(
            s.charAt(0) >= 'a' ? s.charAt(0) + ('A' - 'a') : s.charAt(0) + ('a' - 'A'))
        ).toArray(String[]::new);
    for (String s : str) {
      System.out.print(s);
    }
  }
}