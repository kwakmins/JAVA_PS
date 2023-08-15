import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Queue<Integer> queue = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
    int n = Integer.parseInt(bf.readLine());
    int temp = -99;
    for (int i = 0; i < n; i++) {
      String[] s = bf.readLine().split(" ");
      if (s[0].equals("push")) {
        temp = Integer.parseInt(s[1]);
        queue.add(Integer.parseInt(s[1]));
      } else if (s[0].equals("pop")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue.poll()).append("\n");
        }
      } else if (s[0].equals("size")) {
        sb.append(queue.size()).append("\n");
      } else if (s[0].equals("empty")) {
        sb.append(boolToInt(queue.isEmpty())).append("\n");
      } else if (s[0].equals("front")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue.peek()).append("\n");
        }
      } else if (s[0].equals("back")) {
        if (queue.isEmpty()) {
          sb.append(-1).append("\n");
        } else {
          sb.append(temp).append("\n");
        }
      }
    }
    System.out.println(sb);
  }

  public static int boolToInt(boolean b) {
    if (b) {
      return 1;
    } else {
      return 0;
    }
  }
}
