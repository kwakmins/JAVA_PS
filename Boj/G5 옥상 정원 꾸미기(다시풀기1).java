import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] board = new int[N];

        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && board[stack.peek()] <= board[i]) {
                int pop = stack.pop();

                if (!stack.isEmpty()) {
                    result[stack.peek()] += result[pop] + 1;
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            if (!stack.isEmpty()) {
                result[stack.peek()] += result[pop] + 1;
            }
        }

        // 더 쉬운 방법
        // 위는 pop 할 때 더하는 방식
        // 아래는 stack 사이즈로 누적 크기를 더하는 방식 (stack = 낮은 건물 순 = 볼 수 있는 건물)
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < N; i++) {
//
//            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
//                stack.pop();
//            }
//
//            stack.push(arr[i]);
//            sum += stack.size()-1;
//
//        }

        //  long sum = Arrays.stream(result).sum(); 이건 long 아님!!!!!!!
        long sum = Arrays.stream(result).mapToLong(Long::valueOf).sum();
        System.out.println(sum);

    }

}