import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<Integer> deque = new LinkedList<>();
    String[] s = bf.readLine().split(" ");
    int answer = 0;
    for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
      deque.addLast(i);
    }
    int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i : arr) {
      int a = deque.indexOf(i);
      int b = deque.size() / 2;
      if (a > b) {
        while (deque.peekFirst() != i) {
          deque.addFirst(deque.pollLast());
          answer++;
        }
      } else {
        while (deque.peekFirst() != i) {
          deque.addLast(deque.pollFirst());
          answer++;
        }
      }
      deque.pollFirst();
    }
    System.out.println(answer);
  }
}