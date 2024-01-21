import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * G5 점프 게임 - https://www.acmicpc.net/problem/15558
 * BFS OR 백트래킹 - 두 배열에서 끝 이상의 인덱스로 갈 수 있는 없는지 판단. (한칸 이동,다른 배열의 한칸+K 이동, 전칸 이동)
 *
 * 시간에 따라 갈 수 있는지 없는지로 가지치면서 백트래킹.
 * .
 * @!!! 중복해서 가는 길이 있으면 (-1로 가는 경우 등) 무조건 방문처리.
 * @!!! N는 1000,000이지만, 가지가 많이 쳐져 백트래킹 가능하다고 판단.
 * @!!! -> 방문처리를 안해서 시간 초과 났지만, DP문제로 풀려고 했음.
 * @!!!  -> DP로 하기엔 너무 방대한 경우의 수 존재.
 *
 */
public class Main {

    static int N, K, answer = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        board = new int[2][N];
        for (int i = 0; i < 2; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt)
                .toArray();
        }

        dfs(0, 0, 0);
        System.out.println(0);
    }

    static void dfs(int time, int y, int x) {
        if (x >= N - 1) {
            System.out.println(1);
            System.exit(0);
        }

        if (x + 1 > time && board[y][x + 1] == 1) {
            board[y][x + 1] = 0;
            dfs(time + 1, y, x + 1);
            board[y][x + 1] = 1;
        }

        if (x - 1 >= 0 && board[y][x - 1] == 1 && x - 1 > time) {
            board[y][x - 1] = 0;
            dfs(time + 1, y, x - 1);
            board[y][x - 1] = 1;
        }

        int ay = y == 1 ? 0 : 1;

        if (x + K > time) {
            if (x + K >= N) {
                System.out.println(1);
                System.exit(0);
            } else if (board[ay][x + K] == 1) {
                board[ay][x + K] = 0;
                dfs(time + 1, ay, x + K);
                board[ay][x + K] = 1;
            }
        }
    }
}
