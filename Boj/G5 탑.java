import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 0 값 1 위치
        Stack<int[]> stack = new Stack<>();
        int loc = 1;
        for (int x : arr) {

            while (!stack.isEmpty()) {
                if (stack.peek()[0] >= x) {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }

            stack.push(new int[]{x, loc++});
        }
    }

}
