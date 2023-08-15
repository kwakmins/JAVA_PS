import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> queue = new LinkedList<>();
    int n = Integer.parseInt(bf.readLine());
    int temp = -99;
    for (int i = 0; i < n; i++) {
      String[] s = bf.readLine().split(" ");
      if (s[0].equals("push")) {
        temp = Integer.parseInt(s[1]);
        queue.add(Integer.parseInt(s[1]));
      } else if (s[0].equals("pop")) {
        if (queue.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(queue.poll());
        }
      } else if (s[0].equals("size")) {
        System.out.println(queue.size());
      } else if (s[0].equals("empty")) {
        System.out.println(boolToInt(queue.isEmpty()));
      } else if (s[0].equals("front")) {
        if (queue.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(queue.peek());
        }
      } else if (s[0].equals("back")) {
        if (queue.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(temp);
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
