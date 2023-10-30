/**
 * LV3 정수 삼각형 https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * DP - 삼각형 꼭대기에서 대각선 이동밖에 못할 때, 가장 크게 얻을 수 있는 값 구하기
 *
 * dp로 현재 값 + 이전 왼쪽 대각선의 최대값 or 오른쪽 대각선의 최대값 을 구하면서 나가면 됨
 */
class Solution {

  public int solution(int[][] triangle) {
    int answer = 0;
    int[][] dp = new int[triangle.length + 1][triangle[triangle.length - 1].length];
    dp[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {
        int temp = j != 0 ? dp[i - 1][j - 1] : 0;
        dp[i][j] = Math.max(temp, dp[i - 1][j]) + triangle[i][j];
        if (i == triangle.length - 1) {
          answer = Math.max(dp[i][j], answer);
        }
      }
    }

    return answer;
  }
}