import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @G4 키 순서 - https://www.acmicpc.net/problem/2458
 * 플로이드 워셜 - N명의 사람이 서로 값이 다른 키를 가지고 있을 때, M개의 2사람의 키 비교가 제시될 때, 정확히 키 위치를 알 수 있는 사람 수 구하기
 *
 * 연결(서로 한 방향이라도 무한이 아니라면)되어 있는 수가 N-1이면 알 수 있음. 단방향 문제.
 * .
 * 플로이드 워셜 - 3중 for문으로 거치는 노드 , 시작 , 끝 으로 [시작][끝] or [시작][거침]+[거침][끝] 중 작은 값으로 초기화.
 * N이 500이하면 다익스트라보다 플로이드 워셜이 좋음 (O(N^3))
 * .
 * @!!! 단방향 문제와 연결에 대한 이해도 부족 (이전 노드에서 탐색하려고 했음)
 */
public class Main {

    static final int INF = 999;
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        board = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                board[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            board[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (board[i][j] != INF || board[j][i] != INF) {
                    cnt++;
                }
            }
            if (cnt == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
