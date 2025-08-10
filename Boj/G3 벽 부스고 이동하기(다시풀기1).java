import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        int[][][] visit = new int[N][M][2];
        visit[0][0][0] = 1;
        visit[0][0][1] = 1;

        Queue<int[]> q = new LinkedList<>();
        // 0 = 벽 x
        q.add(new int[]{0, 0, 1, 0});

        while (!q.isEmpty()) {

            int[] poll = q.poll();

            int x = poll[0];
            int y = poll[1];

            int value = poll[2];
            int broke = poll[3];

            if (x == N - 1 && y == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];

                if (ax >= 0 && ay >= 0 && ax < M && ay < N) {

                    if (board[ay][ax].equals("1")) {

                        if (broke == 1) {
                            continue;
                        }

                        if (visit[ay][ax][1] == 0) {
                            visit[ay][ax][1] = value + 1;
                            q.add(new int[]{ax, ay, value + 1, 1});
                        }

                    } else {
                        if (visit[ay][ax][broke] == 0) {

                            visit[ay][ax][broke] = value + 1;
                            q.add(new int[]{ax, ay, value + 1, broke});
                        }
                    }


                }
            }

        }

        /**
         * while 문 중간에 이게 있으면 스킵 가능한데
         *    if (x == M - 1 && y == N - 1) {
         *        result = cnt;
         *        break;
         *    }
         */
        int min = 0;
        if (visit[N - 1][M - 1][0] != 0) {
            min = visit[N - 1][M - 1][0];
        }
        if (visit[N - 1][M - 1][1] != 0) {

            if (min != 0) {
                min = Math.min(min, visit[N - 1][M - 1][1]);
            } else {
                min = visit[N - 1][M - 1][1];
            }
        }

        if (min == 0) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

}