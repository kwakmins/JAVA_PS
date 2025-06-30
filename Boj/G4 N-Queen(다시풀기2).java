import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int result = 0;
    //    static boolean[][] visit;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        visit = new boolean[N][N];
        queen = new int[N];
        nQueen(0);
        System.out.println(result);
    }

    static void nQueen(int deep) {

        if (deep == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[deep] = i;
            if (isPossible(deep)) {
                nQueen(deep + 1);
            }
        }

    }

    static boolean isPossible(int deep) {

        for (int i = 0; i < deep; i++) {
            if (queen[i] == queen[deep]) {
                return false;
            }

            if (Math.abs(i - deep) == Math.abs(queen[i] - queen[deep])) {
                return false;
            }
        }

        return true;
    }

//    static void queen(int cnt, int x, int y, boolean isFirst) {
//
//        if (cnt == N) {
//            result++;
//            return;
//        }
//
//        if (x == N) {
//            y += 1;
//            x = 0;
//        }
//        if (y == N) {
//            return;
//        }
//
//        for (int i = y; i < N; i++) {
//            for (int j = x; j < N; j++) {
//
//                if (!isVisit(j, i)) {
//                    visit[i][j] = true;
//                    queen(cnt + 1, j + 1, i, false);
//                    visit[i][j] = false;
//                }
//
//            }
//            x = 0;
//            if (isFirst) {
//                return;
//            }
//        }
//
//    }
//
//    static boolean isVisit(int x, int y) {
//
//        for (int i = 0; i < N; i++) {
//            if (visit[i][x] == true) {
//                return true;
//            }
//            if (visit[y][i] == true) {
//                return true;
//            }
//
//        }
//
//        // 왼쪽 위 대각선 확인
//        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
//            if (visit[i][j]) {
//                return true;
//            }
//        }
//
//        // 오른쪽 위 대각선 확인
//        for (int i = y - 1, j = x + 1; i >= 0 && j < N; i--, j++) {
//            if (visit[i][j]) {
//                return true;
//            }
//        }
//        return false;
//    }

}



