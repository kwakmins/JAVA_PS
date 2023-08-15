import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      String[] s = bf.readLine().split(" ");
      if (s[0].equals("push")) {
        stack.add(Integer.parseInt(s[1]));
      } else if (s[0].equals("pop")) {
        if (stack.empty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.pop());
        }
      } else if (s[0].equals("size")) {
        System.out.println(stack.size());
      } else if (s[0].equals("empty")) {
        System.out.println(boolToInt(stack.empty()));
      } else if (s[0].equals("top")) {
        if (stack.empty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.peek());
        }
      }
    }
  }

  public static int boolToInt(boolean b) {
    if (b) {
      return 1;
    } else {
      return 0;
    }
  }
}
