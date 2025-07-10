import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);
        int N = Integer.parseInt(line[2]);

        String[][] board = new String[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (board[i][j].equals("O")) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int time = 1;
        while (N != 1) {

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = "O";
                }
            }
            if (++time == N) {
                break;
            }

            while (!q.isEmpty()) {
                int[] xy = q.poll();

                int x = xy[1];
                int y = xy[0];
                board[y][x] = ".";

                for (int i = 0; i < 4; i++) {
                    int ax = x + dx[i];
                    int ay = y + dy[i];

                    if (ax >= 0 && ay >= 0 && ax < C && ay < R) {
                        board[ay][ax] = ".";
                    }
                }
            }
            if (++time == N) {
                break;
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j].equals("O")) {
                        q.add(new int[]{i, j});
                    }
                }
            }

        }

        for (int i = 0; i < R; i++) {
            String s = "";
            for (int j = 0; j < C; j++) {
                s += board[i][j];
            }
            System.out.println(s);
        }
    }
}
