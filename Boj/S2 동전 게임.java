import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S2 동전 게임 - https://www.acmicpc.net/problem/9079
 * 완전탐색 + 비트 마스킹 - 3 X 3 동전 뒤집기를 할 때, 일자로 모두 뒤집을 수 있을 때, 최소 횟수 연산 구하기
 *
 * board 를 Queue에 넣어 완전탐색을 하였음.
 *
 * @!!! 원래 비트 마스킹을 사용해서 visit 방문 처리 해야한다.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < T; t++) {
      String[][] boards = new String[3][3];
      for (int i = 0; i < 3; i++) {
        String[] line = bf.readLine().split(" ");
        for (int j = 0; j < 3; j++) {
          boards[i][j] = line[j];
        }
      }

      Queue<Board> q = new LinkedList<>();
      q.add(new Board(boards, 0));

      while (!q.isEmpty()) {
        Board board = q.poll();
        if (isEnd(board)) {
          sb.append(board.cnt).append("\n");
          break;
        }
        if (board.cnt >= 6) {
          sb.append(-1).append("\n");
          break;
        }
        for (int i = 0; i < 3; i++) {
          q.add(new Board(changeRow(board.boards, i), board.cnt + 1));
          q.add(new Board(changeCol(board.boards, i), board.cnt + 1));
        }
        q.add(new Board(changeMulti1(board.boards), board.cnt + 1));
        q.add(new Board(changeMulti2(board.boards), board.cnt + 1));
      }
    }
    System.out.println(sb);
  }

  static boolean isEnd(Board board) {
    String[][] boards = board.boards;
    String s = boards[0][0];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (!s.equals(boards[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  static String[][] changeRow(String[][] board, int idx) {
    String[][] temp = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == idx) {
          temp[i][j] = board[i][j].equals("H") ? "T" : "H";
        } else {
          temp[i][j] = board[i][j];
        }
      }
    }
    return temp;
  }

  static String[][] changeCol(String[][] board, int idx) {
    String[][] temp = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == idx) {
          temp[i][j] = board[i][j].equals("H") ? "T" : "H";
        } else {
          temp[i][j] = board[i][j];
        }
      }
    }
    return temp;
  }

  static String[][] changeMulti1(String[][] board) {
    String[][] temp = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == i) {
          temp[i][j] = board[i][j].equals("H") ? "T" : "H";
        } else {
          temp[i][j] = board[i][j];
        }
      }
    }
    return temp;
  }

  static String[][] changeMulti2(String[][] board) {
    String[][] temp = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 0) {
          temp[i][j] = board[i][j].equals("H") ? "T" : "H";
        } else {
          temp[i][j] = board[i][j];
        }
      }
    }
    return temp;
  }

  static class Board {

    String[][] boards;
    int cnt;

    public Board(String[][] boards, int cnt) {
      this.boards = boards;
      this.cnt = cnt;
    }
  }
}
