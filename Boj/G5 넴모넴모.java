import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M = 0;
    static long result = 0;
    static boolean[][] visit;

//    static int[] dx = new int[]{1, -1, 0, 0};
//    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        visit = new boolean[N][M];

        dfs(0);
        System.out.println(result);

    }

    static void dfs(int depth) {

        if (depth == N * M) {

//            if (check()) {
            result++;
//            }
            return;
        }

        int x = depth % M;
        int y = depth / M;

        if (isNenmo(x, y)) {
            visit[y][x] = true;
            dfs(depth + 1);
            visit[y][x] = false;
        }

        dfs(depth + 1);

    }

    static boolean check() {

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (visit[i][j] && visit[i][j + 1] && visit[i + 1][j] && visit[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isNenmo(int x, int y) {

        int[] arrX1 = new int[]{-1, -1, 0};
        int[] arrY1 = new int[]{-1, 0, -1};

//        int[] arrX2 = new int[]{0, 1, 1};
//        int[] arrY2 = new int[]{-1, -1, 0};
//
//        int[] arrX3 = new int[]{0, -1, -1};
//        int[] arrY3 = new int[]{1, 0, 1};
//
//        int[] arrX4 = new int[]{0, 1, 1};
//        int[] arrY4 = new int[]{1, 0, 1};

        return executeNenmo(x, y, arrX1, arrY1);
    }

    static boolean executeNenmo(int x, int y, int[] arrX, int[] arrY) {

        int cnt = 0;

        for (int i = 0; i < 3; i++) {

            int ax = x + arrX[i];
            int ay = y + arrY[i];

            if (ax >= 0 && ay >= 0 && ax < M && ay < N) {
                if (visit[ay][ax]) {
                    cnt++;
                }
            }
        }

        return cnt != 3;
    }
}

