class Solution {

  int[][] gArr;
  int[] answer = new int[]{0, 0};

  public int[] solution(int[][] arr) {
    gArr = arr;
    dfs(0, 0, arr.length);
    return answer;
  }

  void dfs(int x, int y, int n) {
    if (n == 1) {
      answer[gArr[y][x]]++;
      return;
    }

    int a = gArr[y][x];
    for (int i = y; i < y + n; i++) {
      for (int j = x; j < x + n; j++) {
        if (a != gArr[i][j]) {
          dfs(x, y, n / 2);
          dfs(x + n / 2, y, n / 2);
          dfs(x, y + n / 2, n / 2);
          dfs(x + n / 2, y + n / 2, n / 2);
          return;
        }
      }

    }
    answer[a]++;
  }

}