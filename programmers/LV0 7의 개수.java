import java.util.*;
import java.util.stream.*;

class Solution {

  public int solution(int[] array) {
    return (int) Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.toList())
        .stream().mapToInt(s -> (int) s.chars().filter(c -> c == '7').count()).sum();
  }
}