import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] visit;
    static int sum = 0, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N][N];

        dfs(0, 0, 0);
        System.out.println(sum);

    }

    static void dfs(int x, int y, int cnt) {

        if (cnt == N) {
            sum++;
            return;
        }

        for (int i = y; i < N; i++) {

            // 이걸 하면 완전 탐색으로 가능하긴함 (시초)
            if (i != y) {
                x = 0;
            }
            for (int j = x; j < N; j++) {

                if (!isVisit(j, i)) {

                    visit[i][j] = true;

                    // 그냥 0부터 방문하자 방식
//                    dfs(0, i + 1, cnt + 1);

                    // 이러면 j=x부터 시작이라 그 전값은 영원히 못접근함
                    // dfs(4,1,1) -> (2,4),(2,5)...(3,0)불가능 (3,4) 부터시작
                    if (j == N - 1) {
                        dfs(0, i + 1, cnt + 1);
                    } else {
                        dfs(j + 1, i, cnt + 1);
                    }

                    visit[i][j] = false;

                }

            }
        }

    }

    static boolean isVisit(int x, int y) {

        for (int i = 0; i < N; i++) {
            if (visit[i][x] == true) {
                return true;
            }
            if (visit[y][i] == true) {
                return true;
            }

            if (y + i < N && x + i < N) {
                if (visit[y + i][x + i] == true) {
                    return true;
                }
            }
            if (y + i < N && x - i >= 0) {
                if (visit[y + i][x - i] == true) {
                    return true;
                }
            }
            if (y - i >= 0 && x - i >= 0) {
                if (visit[y - i][x - i] == true) {
                    return true;
                }
            }
            if (y - i >= 0 && x + i < N) {
                if (visit[y - i][x + i] == true) {
                    return true;
                }
            }

        }
        return false;
    }

    // 이렇게 방문 처리하면, 복구 시 해당 퀸이 아닌 다른 퀸의 겹치는 경로도 false가 되어버림
//    static void queenVisit(int x, int y, boolean b) {
//
//        for (int i = 0; i < N; i++) {
//            visit[i][x] = b;
//            visit[y][i] = b;
//
//            if (y + i < N && x + i < N) {
//                visit[y + i][x + i] = b;
//            }
//            if (y + i < N && x - i >= 0) {
//                visit[y + i][x - i] = b;
//            }
//            if (y - i >= 0 && x - i >= 0) {
//                visit[y - i][x - i] = b;
//            }
//            if (y - i >= 0 && x + i < N) {
//                visit[y - i][x + i] = b;
//            }
//
//        }
//    }

//
}