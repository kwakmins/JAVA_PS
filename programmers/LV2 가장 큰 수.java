import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {

  public String solution(int[] numbers) {
    String s = Arrays.stream(numbers)
        .boxed()
        .map(Objects::toString)
        .sorted((a, b) -> (b + a).compareTo(a + b))
        .collect(Collectors.joining());
    BigInteger bi = new BigInteger(s);
    return bi.toString();
  }
}