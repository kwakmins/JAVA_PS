import java.util.*;
import java.util.stream.*;

class Solution {

  public String solution(String input_string) {
    String[] strings = input_string.split("");
    Set<String> set = new HashSet<>();
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < strings.length; i++) {
      if (!stack.isEmpty() && !stack.peek().equals(strings[i])) {
        if (stack.contains(strings[i])) {
          set.add(strings[i]);
        }
      }
      stack.push(strings[i]);
    }
    if (set.isEmpty()) {
      return "N";
    }
    return set.stream().sorted().collect(Collectors.joining());
  }
}