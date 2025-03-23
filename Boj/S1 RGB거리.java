import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] d, board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);
        d = new int[N + 1][3];
        board = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            board[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 3; i++) {
            d[1][i] = board[1][i];
        }

        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + board[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + board[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + board[i][2];
        }

        System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
    }
}