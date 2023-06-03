import java.util.*;
import java.util.stream.Collectors; // 따로 써야함

class Solution {
  public String solution(String my_string) {

    return Arrays.stream(my_string.toLowerCase().split("")).sorted().collect(Collectors.joining());
  }
}