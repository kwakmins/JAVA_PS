/**
 * @Lv3 스티커 모으기(2) https://school.programmers.co.kr/learn/courses/30/lessons/12971#
 * DP - 원형 숫자 스트커판에서 하나를 뽑으면 양쪽이 뽑힐때, 가장 큰 숫자 구하기
 *
 * 맨처음 숫자를 뽑냐 안뽑냐 두 가지 케이스의 DP를 구하면 된다.
 * - dp[i] = max(i 숫자 뽑기 + i-2의 dp, i 숫자를 안뽑는 i-1의 dp)
 * .
 * @!!! dp를 생각할 때, dp[i]는 i숫자를 무조건 포함한다고 생각했음. i번째에서 가장 큰 수를 구하는 거임.
 */
class Solution {

  public int solution(int sticker[]) {
    if (sticker.length == 1) {
      return sticker[0];
    }
    int answer = 0;
    int[] dp = new int[sticker.length];
    dp[0] = sticker[0];
    dp[1] = dp[0];
    for (int i = 2; i < sticker.length - 1; i++) {
      dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
    }

    int[] dp2 = new int[sticker.length];
    dp2[0] = 0;
    dp2[1] = sticker[1];
    for (int i = 2; i < sticker.length; i++) {
      dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
    }
    answer = Math.max(dp[sticker.length - 2], dp2[sticker.length - 1]);

    return answer;
  }
}