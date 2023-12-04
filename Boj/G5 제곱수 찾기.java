import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G5 제곱수 찾기 - https://www.acmicpc.net/problem/1025
 * 구현 - 숫자로된 보드에서 행,열 모두 등차 수열로 모든 탐색이 가능할 때, 가장 큰 완전제곱수 구하기
 *
 * 4중 for문으로 등차 수열 모두 계산.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    String[][] board = new String[N][M];
    int max = -1;
    for (int i = 0; i < N; i++) {
      String[] line2 = bf.readLine().split("");
      for (int j = 0; j < line2.length; j++) {
        board[i][j] = line2[j];
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int di = -N; di < N; di++) {
          for (int dj = -M; dj < M; dj++) {

            if (di == 0 && dj == 0) {
              continue;
            }

            int ay = i;
            int ax = j;
            String num = "";
            while (ay >= 0 && ax >= 0 && ay < N && ax < M) {
              num += board[ay][ax];

              int a = Integer.parseInt(num);
              if (Math.sqrt(a) % 1 == 0) {
                max = Math.max(max, a);
              }
              ay += di;
              ax += dj;
            }
          }
        }
      }
    }
    System.out.println(max);
  }
}
