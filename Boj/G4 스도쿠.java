import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * G4 스도쿠 - https://www.acmicpc.net/problem/2239
 * 백트래킹 - 비어있는 스도쿠 판 채우기
 *
 * 스도쿠 규칙에 맞게 모든 수 백트래킹 하면 됨.
 *
 * @!!! for문에 DFS넣을 때 조심! (다음처리는 다음DFS에서 해주는데, for문으로 인해 이번 DFS에서도 처리됨)
 */
public class Main {

    static int[][] board = new int[9][9];
    static int cnt = 0;
    static boolean b = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }

        dfs(0, 0, 0);
    }

    static void dfs(int y, int x, int cnt2) {
        if (b) {
            return;
        }

        if (cnt2 == cnt) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            b = true;
            return;
        }

        for (int i = y; i < 9; i++) {
            for (int j = i == y ? x : 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (check(i, j, k)) {
                            board[i][j] = k;
                            dfs(i, j, cnt2 + 1);
                            board[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    static boolean check(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value || board[i][x] == value) {
                return false;
            }
        }

        int ay = y / 3 * 3;
        int ax = x / 3 * 3;
        for (int i = ay; i < ay + 3; i++) {
            for (int j = ax; j < ax + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
