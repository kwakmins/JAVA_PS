import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[][][] cost = new int[N][M][K + 1];
        // x,y,cnt,k
        q.add(new int[]{0, 0, 1, 0});
        cost[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int x = poll[1];
            int y = poll[0];
            int cnt = poll[2];
            int k = poll[3];

            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];

                if (ax >= 0 && ay >= 0 && ax < M && ay < N) {

                    if (board[ay][ax] == 0 && cost[ay][ax][k] == 0) {
                        cost[ay][ax][k] = cnt + 1;
                        q.add(new int[]{ay, ax, cnt + 1, k});
                    } else if (board[ay][ax] == 1) {
                        if (k + 1 <= K && cost[ay][ax][k + 1] == 0) {
                            cost[ay][ax][k + 1] = cnt + 1;
                            q.add(new int[]{ay, ax, cnt + 1, k + 1});
                        }
                    }
                }
            }

        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            if (cost[N - 1][M - 1][i] != 0) {
                min = Math.min(min, cost[N - 1][M - 1][i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}

