class Solution {

  public int[][] solution(int n) {
    int[][] answer = new int[n][n];
    int x = 1, row = 0, col = 0, a = 0;

    while (x <= n * n) {
      answer[row][col] = x++;
      if (a == 0) {
        if (col == n - 1 || answer[row][col + 1] != 0) {
          a = 1;
          row++;
        } else {
          col++;
        }
      } else if (a == 1) {
        if (row == n - 1 || answer[row + 1][col] != 0) {
          a = 2;
          col--;
        } else {
          row++;
        }
      } else if (a == 2) {
        if (col == 0 || answer[row][col - 1] != 0) {
          a = 3;
          row--;
        } else {
          col--;
        }
      } else if (a == 3) {
        if (row == 0 || answer[row - 1][col] != 0) {
          a = 0;
          col++;
        } else {
          row--;
        }
      }
    }

    return answer;
  }
}