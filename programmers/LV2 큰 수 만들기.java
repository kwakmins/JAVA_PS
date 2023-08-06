import java.util.*;

class Solution {

  public String solution(String number, int k) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < number.length(); i++) {
      while (!stack.isEmpty() && stack.peek() - '0' < number.charAt(i) - '0' && k > 0) {
        stack.pop();
        k--;
      }
      stack.push(number.charAt(i));
    }
    while (k > 0) {
      stack.pop();
      k--;
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}