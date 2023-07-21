import java.util.*;

class Solution {

  public String[] solution(String myString) {
    String[] answer = myString.split("x");
    String[] a = Arrays.stream(answer)
        .filter(s -> !s.equals(""))
        .sorted()
        .toArray(String[]::new);
    return a;
  }
}