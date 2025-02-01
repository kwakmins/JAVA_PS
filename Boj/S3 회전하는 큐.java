import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        String[] s2 = br.readLine().split(" ");

        int result = 0;

        for (String s : s2) {

            int a = Integer.parseInt(s);

            if (deque.peek() == a) {
                deque.pollFirst();
                continue;
            }

            int indexOf = deque.indexOf(a);
            int rightValue = deque.size() - 1 + 1 - indexOf;

            // 3 오른쪽 이동
            if (rightValue < indexOf) {
                while (rightValue-- > 0) {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            } else {
                while (indexOf-- > 0) {
                    deque.addLast(deque.pollFirst());
                    result++;
                }
            }

            deque.pollFirst();
        }
        System.out.println(result);
    }
}
