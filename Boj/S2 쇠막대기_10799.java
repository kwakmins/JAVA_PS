import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    Stack<String> stack = new Stack<>();
    int answer = 0, x = 0;
    for (String ss : s.split("")) {
      if (ss.equals(")")) {
        x--;
        if (stack.peek().equals("(")) {
          answer += x;
        } else {
          answer++;
        }
        stack.add(ss);
      } else {
        stack.add(ss);
        x++;
      }
    }
    System.out.println(answer);
  }
}