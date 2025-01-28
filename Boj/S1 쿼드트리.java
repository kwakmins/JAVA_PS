import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 쿼드트리 - https://www.acmicpc.net/problem/1992
 * 백트래킹 - 데이터 압축하기
 *
 * @!!! 탐색 범위를 잘못잡아 많이 틀렸음. 배열이 있으면 범위는 잘 선정하자
 */
public class Main {

    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split(" ");
        int N = Integer.parseInt(line[0]);

        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = bf.readLine().split("");
        }

        quad(0, 0, N);

    }

    static void quad(int y, int x, int n) {

        if (isAllSame(y, x, n)) {
            System.out.print(board[y][x]);
        } else {
            System.out.print("(");
            int temp = n / 2;
            quad(y, x, temp);
            quad(y, x + temp, temp);
            quad(y + temp, x, temp);
            quad(y + temp, x + temp, temp);
            System.out.print(")");
        }
    }

    static boolean isAllSame(int y, int x, int n) {
        String s = board[y][x];

        for (int i = y; i < y + n; i++) { // i=0 으로 해서 엄청 틀렸음
            for (int j = x; j < x + n; j++) {
                if (!board[i][j].equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}