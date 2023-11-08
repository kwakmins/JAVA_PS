/**
 * LV3 등굣길 https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * DP - 자칫 DFS/BFS로 볼 수 있는 문제. 오른쪽, 아래쪽으로 밖에 못갈 때. (0,0) 에서 (m,n) 끝까지 가는 경우의 수 계산
 *
 * DP로 재귀를 통해 ,왼쪽에서 오는 경우의 수 + 위에서 오는 경우의 수 를 구한다.
 * 최소 거리이지만 DFS/BFS가 아닌 이유는, 어느쪽으로 가도 도착하는게 최소 거리이기 때문.
 *
 * @!!! 문제의 x,y 헷갈렸음..
 */
class Solution {

  int[][] puddle;
  long[][] dps;

  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    puddle = new int[n][m];
    dps = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dps[i][j] = -1;
      }
    }
    for (int[] i : puddles) {
      puddle[i[1] - 1][i[0] - 1] = 1;
    }
    dps[0][1] = 1;
    dps[1][0] = 1;
    dps[0][0] = 0;
    dp(n - 1, m - 1);
    return (int) dps[n - 1][m - 1];
  }

  public long dp(int y, int x) {
    if (x < 0 || y < 0) {
      return 0;
    }
    if (puddle[y][x] == 1) {
      return 0;
    }
    if (dps[y][x] != -1) {
      return dps[y][x];
    }
    return dps[y][x] = (dp(y - 1, x) + dp(y, x - 1)) % 1000000007;
  }
}