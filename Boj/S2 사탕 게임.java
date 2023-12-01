import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S2 사탕 게임 -https://www.acmicpc.net/problem/3085
 * 완전탐색 - 사탕 보드에서 두 사탕 위치를 바꿀 수 있을 때, 가장 긴 연속 부분 사탕 수 구하기
 *
 * 모든 위치를 바뀌는 경우의 수 마다 가장 긴 연속 부분 사탕 수 구하면 됨
 */
public class Main {

  static String[][] board;
  static int N;
  static int maxSum = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    board = new String[N][N];
    for (int i = 0; i < N; i++) {
      String[] line = bf.readLine().split("");
      for (int j = 0; j < line.length; j++) {
        board[i][j] = line[j];
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        String a = board[i][j];
        String b = board[i][j + 1];
        if (!a.equals(b)) {
          board[i][j] = b;
          board[i][j + 1] = a;
          cal();
          board[i][j] = a;
          board[i][j + 1] = b;
        }

        String a2 = board[j][i];
        String b2 = board[j + 1][i];
        if (!a2.equals(b2)) {
          board[j][i] = b2;
          board[j + 1][i] = a2;
          cal();
          board[j][i] = a2;
          board[j + 1][i] = b2;
        }
      }
    }
    System.out.println(maxSum);
  }

  static void cal() {
    for (int i = 0; i < N; i++) {
      int sum = 1;
      int tempSum = 1;
      int sum2 = 1;
      int tempSum2 = 1;

      for (int j = 1; j < N; j++) {
        if (board[i][j - 1].equals(board[i][j])) {
          tempSum++;
          sum = Math.max(sum, tempSum);
        } else {
          tempSum = 1;
        }

        if (board[j - 1][i].equals(board[j][i])) {
          tempSum2++;
          sum2 = Math.max(sum2, tempSum2);
        } else {
          tempSum2 = 1;
        }
      }
      maxSum = Math.max(maxSum, sum);
      maxSum = Math.max(maxSum, sum2);
    }

  }
}
