import java.util.Arrays;

/**
 *
 */
class Solution {

  public int solution(int[][] land) {
    int num = 0;
    int[][] arr = new int[land.length][4];

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[i].length; j++) {
        if (i == 0) {
          arr[i][j] = land[i][j];
          continue;
        }
        for (int k = 0; k < 4; k++) {
          if (k == j) {
            continue;
          }
          num = Math.max(num, arr[i - 1][k]);
        }
        arr[i][j] = num + land[i][j];
        num = 0;
      }
    }
    return Arrays.stream(arr[land.length - 1]).max().orElseThrow();
  }
}
