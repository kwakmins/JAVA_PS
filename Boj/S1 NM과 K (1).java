import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S1 NM과 K (1) - https://www.acmicpc.net/problem/18290
 * 백트래킹 - Board에서 K만큼 수를 선택할 때, 인접하지 않게 고르면서 가장 큰 합 구하기.
 *
 * 콤비네이션 + 인접한 visit이 있는지 확인하기
 *
 * @!!! 인접한 Visit을 확인하지 않고 선택 인접 노드 모두 방문처리 하였음 -> 백트래킹 나오면서 다른 노드의 인접 노드까지 방문 False 처리 되어버림..
 * @!!! 방문처리는 진짜 방문한 곳만 해야 안꼬임
 */
public class Main {

    static int N, M, K, answer = Integer.MIN_VALUE;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        board = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }
        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == K) {
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = (y == i) ? x : 0; j < M; j++) {

                boolean b = false;
                if (!visit[i][j]) {

                    for (int k = 0; k < 4; k++) {
                        int ax = j + dx[k];
                        int ay = i + dy[k];
                        if (ax >= 0 && ay >= 0 && ax < M && ay < N) {
                            if (visit[ay][ax]) {
                                b = true;
                            }
                        }
                    }
                    if (!b) {
                        visit[i][j] = true;
                        dfs(j, i, sum + board[i][j], cnt + 1);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }
}
