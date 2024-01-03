import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * S2 점프점프 - https://www.acmicpc.net/problem/14248
 * DFS,BFS - 돌다리에서 좌우로 주어진 수만큼 이동 할 수 있을때, 방문 가능한 돌다리 수 구하기
 *
 * DFS로 모든 경우의 수 방문하면 됨. (문제를 잘못읽어 한번에 최대로 방문한 수를 계산했었음)
 */
public class Main {

    static int n, s, answer = 1;
    static int[] board, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visit = new int[n];
        s = Integer.parseInt(bf.readLine());
        visit[s - 1] = 1;
        dfs(s);

        System.out.println(answer);
    }

    static void dfs(int x) {
        if (x + board[x - 1] <= n) {
            if (visit[x + board[x - 1] - 1] == 0) {
                visit[x + board[x - 1] - 1]++;
                answer++;
                dfs(x + board[x - 1]);
            }
        }

        if (x - board[x - 1] > 0) {
            if (visit[x - board[x - 1] - 1] == 0) {
                visit[x - board[x - 1] - 1]++;
                answer++;
                dfs(x - board[x - 1]);
            }
        }
    }
}
