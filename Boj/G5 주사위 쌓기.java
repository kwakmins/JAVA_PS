import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * G5 주사위 쌓기 - https://www.acmicpc.net/problem/2116
 * 구현 - 여러 주사위를 같은 숫자를 마주보게 한줄로 쌓을 때, 한 면의 합이 가장 크게 쌓을 때의 값 구하기.
 *
 * (0,5) (1,3) (2,4)가 서로 반대위치 -> 위를 0,1,2 로 하면 자동으로 아래는 5,3,4. 가장 큰 면은 위 아래가 아닌 면.
 * 위의 값을 가진 2중 배열을 이전 값 중 자신의 아랫면이 윗면인 것을 더하면서 나감.
 *
 * @!!! 구현을 좀 더 제대로 설계하자 (틀려서 오래걸림)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][6];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }
        int[][] dp = new int[N][7];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int x1 = 0, x2 = 0;

                if (j == 0) {
                    x1 = board[i][0];
                    x2 = board[i][5];
                }

                if (j == 1) {
                    x1 = board[i][1];
                    x2 = board[i][3];
                }

                if (j == 2) {
                    x1 = board[i][2];
                    x2 = board[i][4];
                }

                for (int k = 0; k < 6; k++) {
                    if (board[i][k] == x1 || board[i][k] == x2) {
                        continue;
                    }
                    dp[i][x1] = Math.max(dp[i][x1], board[i][k]);
                    dp[i][x2] = Math.max(dp[i][x2], board[i][k]);

                }
                if (i != 0) {
                    dp[i][x1] += dp[i - 1][x2];
                    dp[i][x2] += dp[i - 1][x1];
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 6; i++) {
            answer = Math.max(answer, dp[N - 1][i]);
        }
        System.out.println(answer);
    }
}
