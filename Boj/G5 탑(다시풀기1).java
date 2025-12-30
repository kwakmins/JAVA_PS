import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty()) {

                int peek = stack.peek();

                if (board[i] >= board[peek]) {
                    stack.pop();
                } else {
                    sb.append(peek + 1).append(" ");
                    stack.push(i);
                    break;
                }

            }

            if (stack.isEmpty()) {

                stack.add(i);
                sb.append(0).append(" ");
            }

        }

        System.out.println(sb);
    }
}