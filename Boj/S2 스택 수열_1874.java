import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sbf = new StringBuffer();
    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(bf.readLine());
    }

    int i = 0, num = 1;
    while (num < n + 2) {
      if (!stack.empty() && stack.peek() == arr[i]) {
        sbf.append("-").append("\n");
        stack.pop();
        i++;
      } else {
        if (num == n + 1) {
          break;
        }
        stack.add(num);
        sbf.append("+").append("\n");
        num++;
      }
    }
    if (!stack.empty()) {
      System.out.println("NO");
    } else {
      System.out.println(sbf);
    }
  }
}