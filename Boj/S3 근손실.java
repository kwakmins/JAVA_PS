import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * S3 근손실 - https://www.acmicpc.net/problem/18429
 * 백트래킹 - 모든 보드를 거칠 때, 음수가 되는 경우 없는 순서 방법 구하기
 * 
 * 탐색을 할 때, 음수가 되는지 확인하며 탐색
 */
public class Main {

  static int N, M, answer = 0;
  static int[] board;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    visit = new boolean[N];
    board = new int[N];
    String[] line2 = bf.readLine().split(" ");
    for (int i = 0; i < line2.length; i++) {
      board[i] = Integer.parseInt(line2[i]);
    }

    dfs(0, 0);
    System.out.println(answer);
  }

  static void dfs(int kg, int cnt) {
    if (cnt == N) {
      answer++;
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!visit[i] && kg - M + board[i] >= 0) {
        visit[i] = true;
        dfs(kg - M + board[i], cnt + 1);
        visit[i] = false;
      }
    }
  }
}
