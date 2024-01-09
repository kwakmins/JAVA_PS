import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @G5 배열 돌리기2 - https://www.acmicpc.net/problem/16927
 * 구현 - 숫자보드에서 겉에서부터 배열을 반시계로 10억 이하 R만큼 돌릴 때, 만들어지는 숫자보드
 *
 * 1. 돌려지는 겉부분 총 개수는 N과 M중 작은 수 /2이다. 조건 min(N, M) mod 2 = 0
 * 2. 시간 초과 나니까 R만큼 돌리지 않고, R % 원점이 되는 기준 길이( nN + 2 * nM - 4) 를 구해 그만큼만 돌린다.
 * 3. dx[] dy[] 로 진행하면서, 이전값 prev로 저장, 임시값 temp로 저장 하면서 바꿔나가기.
 * @!!! 조건 min(N,M) mod2 =0 를 이해못함.
 * @!!! 특정 방향 진행 dx[] dy[] while 문으로 쉽게 구현 가능
 */
public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }

        int nN = N;
        int nM = M;
        for (int i = 0; i < Math.min(M, N) / 2; i++) {
            rotate(i, 2 * nN + 2 * nM - 4);  // 총 횟수
            nN -= 2;
            nM -= 2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int start, int cnt) {
        cnt = R % cnt;

        for (int i = 0; i < cnt; i++) {
            int pre = board[start][start];
            int temp = 0;

            int idx = 0;
            int x = start;
            int y = start;
            while (idx < 4) {
                int ax = x + dx[idx];
                int ay = y + dy[idx];

                if (ax >= start && ay >= start && ax < M - start && ay < N - start) {
                    temp = board[ay][ax];
                    board[ay][ax] = pre;
                    pre = temp;
                    x = ax;
                    y = ay;
                } else {
                    idx++;
                }
            }
            board[start + 1][start] = temp;
        }
    }


}
