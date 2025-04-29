import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] board;
    static int cnt = 0, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][2];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        func(0, 0);
        System.out.println(cnt);
    }

    static void func(int n, int tempCnt) {

        if (tempCnt == N) {
            System.out.println(cnt);
            System.exit(0);
        }

        if (n == N) {
            return;
        }

        if (board[n][0] <= 0) {
            func(n + 1, tempCnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == n) {
                continue;
            }

            if (board[i][0] > 0) {
                board[i][0] -= board[n][1];
                board[n][0] -= board[i][1];

                int broken = 0;
                if (board[i][0] <= 0) {
                    broken++;
                }
                if (board[n][0] <= 0) {
                    broken++;
                }

                cnt = Math.max(cnt, tempCnt + broken);

                func(n + 1, tempCnt + broken);

                board[i][0] += board[n][1];
                board[n][0] += board[i][1];
            }


        }

    }

}