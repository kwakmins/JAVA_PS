import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static boolean[][] visited;
    static int[][] board;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(board[i][j], max);
            }
        }

        int result = 0;

        for (int t = 0; t <= max; t++) {

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] <= t) {
                        visited[i][j] = true;
                    }
                }
            }

            int tempMax = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        dfs(j, i);
                        tempMax++;
                    }
                }
            }

            result = Math.max(result, tempMax);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {

            int ax = x + dx[i];
            int ay = y + dy[i];

            if (ax >= 0 && ay >= 0 && ax < N && ay < N && !visited[ay][ax]) {
                visited[ay][ax] = true;
                dfs(ax, ay);
            }
        }
    }
}