import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cursor = 1;

        while (!q.isEmpty()) {

            Integer pollInt = q.poll();

            if (!stack.isEmpty() && stack.peek() > pollInt) {
                System.out.println("NO");
                System.exit(0);
            }

            while (stack.isEmpty() || !stack.peek().equals(pollInt)) {
                stack.add(cursor++);
                sb.append("+").append("\n");
            }
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb.toString());
    }

}
