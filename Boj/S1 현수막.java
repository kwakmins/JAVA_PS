import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S1 현수막 - https://www.acmicpc.net/problem/14716
 * BFS,DFS - 1이 인접(대각선 포함)한 것이 글자일 때, 글자의 총 수 구하기.
 *
 * 방문하지 않는 1의 인접한 1 모두 방문 처리(완탐) 반복
 */
public class Main {

    static int N, M;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    answer++;
                    visit[i][j] = true;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();
                        for (int z = 0; z < 8; z++) {
                            int ax = dx[z] + temp[1];
                            int ay = dy[z] + temp[0];
                            if (ax >= 0 && ay >= 0 && ax < M && ay < N && board[ay][ax] == 1
                                && !visit[ay][ax]) {
                                visit[ay][ax] = true;
                                q.add(new int[]{ay, ax});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
