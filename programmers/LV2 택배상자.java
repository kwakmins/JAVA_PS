import java.util.Stack;

class Solution {

  public static int solution(int[] order) {
    int answer = 0;
    int o = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 1; i <= order.length; i++) {
      if (order[o] != i) {
        if (stack.isEmpty()) {
          stack.add(i);
          continue;
        }
        boolean b = false;
        while (true) {
          if (!stack.empty() && stack.peek() == order[o]) {
            stack.pop();
            answer++;
            o++;
            b = true;
          } else {
            if (b) {
              i--;
            } else {
              stack.add(i);
            }
            break;
          }
        }
      } else {
        o++;
        answer++;
      }
    }
    while (true) {
      if (!stack.empty() && stack.peek() == order[o]) {
        stack.pop();
        answer++;
        o++;
      } else {
        break;
      }
    }
    return answer;
  }
}
  