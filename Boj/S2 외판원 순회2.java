import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            func(i, 0, i, 0);
        }
        
        System.out.println(min);
    }

    static void func(int startIdx, int value, int currentIdx, int cnt) {

        if (cnt == N - 1) {

            if (board[currentIdx][startIdx] != 0) {
                min = Math.min(min, value + board[currentIdx][startIdx]);
            }

            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visit[i] && board[currentIdx][i] != 0 && i != startIdx) {

                visit[i] = true;
                func(startIdx, value + board[currentIdx][i], i, cnt + 1);
                visit[i] = false;
            }
        }

    }
}

