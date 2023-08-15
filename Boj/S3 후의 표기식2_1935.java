import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    Map<String, Double> map = new HashMap<>();
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Stack<Double> stack = new Stack<>();
    int n = Integer.parseInt(bf.readLine());
    String problem = bf.readLine();
    char c = 'A';
    for (int i = 0; i < n; i++) {
      map.put(String.valueOf(c), Double.valueOf(bf.readLine()));
      c++;
    }
    for (String s : problem.split("")) {
      if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
        stack.add(map.get(s));
      } else {
        if (s.equals("*")) {
          stack.add(stack.pop() * stack.pop());
        } else if (s.equals("+")) {
          stack.add(stack.pop() + stack.pop());
        } else if (s.equals("-")) {
          stack.add(-stack.pop() + stack.pop());
        } else if (s.equals("/")) {
          double first = stack.pop();
          double second = stack.pop();
          stack.add(second / first);
        }
      }
    }
    System.out.printf("%.2f", stack.peek());
  }
}