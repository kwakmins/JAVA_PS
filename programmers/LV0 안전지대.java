import java.util.*;

class Solution {

  public int solution(int[][] board) {
    int answer = 0;
    int[][] map = new int[board.length][board[0].length];
    int dx[] = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    int dy[] = new int[]{1, 0, -1, 1, -1, 1, 0, -1};
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 1) {
          map[i][j] = 1;
          for (int k = 0; k < 8; k++) {
            int x = j + dx[k];
            int y = i + dy[k];
            if (x >= 0 && y >= 0 && x < board[0].length && y < board.length && map[y][x] == 0
                && board[y][x] == 0) {
              map[y][x] = 1;
            }
          }
        }
      }
    }

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == 0) {
          answer++;
        }
      }
    }
    return answer;
  }
}