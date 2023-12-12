import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 오목 - https://www.acmicpc.net/problem/2615
 * 구현 (완전탐색) - 오목 경기의 승 패 구하고, 가장 왼쪽에 있는 승리한 알 구하기.
 *
 * 위에서부터 4가지 방향 (밑,오른쪽,오른쪽+위 대각선,오른쪽 + 아래 다각선)탐색.
 * 방향 시작의 이전 값도 같은 돌이면, 이미 전에 탐색한 값이라 탐색 X ( 1 1 1 1 1 1 이면 두번째 1부터 시작하면 5목이됨)
 */
public class Main {

  static String[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    board = new String[19][19];

    for (int i = 0; i < 19; i++) {
      board[i] = bf.readLine().split(" ");
    }

    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (!board[i][j].equals("0")) {

          if (isOmok(board[i][j], j, i)) {
            System.out.println(board[i][j]);
            System.out.println((i + 1) + " " + (j + 1));
            System.exit(0);
          }
        }
      }
    }
    System.out.println(0);
  }

  public static boolean isOmok(String s, int x, int y) {
    if (search1(s, x, y)) {
      return true;
    }
    if (search2(s, x, y)) {
      return true;
    }
    if (search3(s, x, y)) {
      return true;
    }
    if (search4(s, x, y)) {
      return true;
    }
    return false;
  }

  public static boolean search1(String s, int x, int y) {
    // 이전값도 같으면 이미 전에 해본값 ( 6목의 2자리수 부터 시작해서 5목이라고 판단되어 문제됨)
    if (y - 1 >= 0 && board[y - 1][x].equals(s)) {
      return false;
    }

    for (int i = 1; i < 6; i++) {
      if (i == 5) {
        if (y + i == 19) {
          return true;
        }

        if (board[y + i][x].equals(s)) {
          return false;
        }
        continue;
      }

      if (y + i >= 19) {
        return false;
      }
      if (!board[y + i][x].equals(s)) {
        return false;
      }
    }
    return true;
  }

  public static boolean search2(String s, int x, int y) {
    if (x - 1 >= 0 && board[y][x - 1].equals(s)) {
      return false;
    }

    for (int i = 1; i < 6; i++) {
      if (i == 5) {
        if (x + i == 19) {
          return true;
        }
        if (board[y][x + i].equals(s)) {
          return false;
        }
        continue;
      }

      if (x + i >= 19) {
        return false;
      }
      if (!board[y][x + i].equals(s)) {
        return false;
      }
    }
    return true;
  }

  public static boolean search3(String s, int x, int y) {
    if (x - 1 >= 0 && y - 1 >= 0 && board[y - 1][x - 1].equals(s)) {
      return false;
    }

    for (int i = 1; i < 6; i++) {
      if (i == 5) {
        if (y + i == 19 || x + i == 19) {
          return true;
        }
        if (board[y + i][x + i].equals(s)) {
          return false;
        }
        continue;
      }

      if (x + i >= 19 || y + i >= 19) {
        return false;
      }
      if (!board[y + i][x + i].equals(s)) {
        return false;
      }
    }
    return true;
  }

  public static boolean search4(String s, int x, int y) {
    if (x - 1 >= 0 && y + 1 < 19 && board[y + 1][x - 1].equals(s)) {
      return false;
    }

    for (int i = 1; i < 6; i++) {
      if (i == 5) {
        if (y - i == -1 || x + i == 19) {
          return true;
        }
        if (board[y - i][x + i].equals(s)) {
          return false;
        }
        continue;
      }

      if (x + i >= 19 || y - i < 0) {
        return false;
      }
      if (!board[y - i][x + i].equals(s)) {
        return false;
      }
    }
    return true;
  }
}
