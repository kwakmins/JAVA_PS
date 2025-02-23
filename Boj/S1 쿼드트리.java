import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        func(0, 0, N);
        System.out.println(sb);
    }

    static void func(int startX, int startY, int n) {

        if (n == 1) {
            sb.append(board[startY][startX]);
            return;
        }

        if (valid(startX, startY, n)) {
            sb.append(board[startY][startX]);
            return;
        }

        sb.append("(");
        func(startX, startY, n / 2);
        func(startX + n / 2, startY, n / 2);
        func(startX, startY + n / 2, n / 2);
        func(startX + n / 2, startY + n / 2, n / 2);
        sb.append(")");

    }

    static boolean valid(int x, int y, int n) {

        String s = board[y][x];

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (!board[i][j].equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}