import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/***
 *
 */

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(Arrays.stream(bf.readLine().split("")).sorted(Collections.reverseOrder())
        .collect(Collectors.joining()));
  }
}