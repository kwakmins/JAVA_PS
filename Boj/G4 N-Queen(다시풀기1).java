import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] board;
    static int sum = 0, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];

        dfs(0);
        System.out.println(sum);

    }

    static void dfs(int depth) {

        if (depth == N) {
            sum++;
            return;
        }

        for (int i = 0; i < N; i++) {

            board[depth] = i;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }

        }

    }

    static boolean isPossible(int depth) {

        for (int i = 0; i < depth; i++) {

            if (board[i] == board[depth]) {
                return false;
            }

            if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
                return false;
            }

        }
        return true;

    }
}