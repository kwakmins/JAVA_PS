/**
 * LV2 n진수 게임 https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * N진수 구현 - 숫자 끊어 말하기를 n진수로 하는 코딩 동아리...?
 *
 * 말해야하는 순서를 계산하여, 정답 문자열에 추가.
 * @!!! Intger.toString(int i, N진수의 N) 로 진수 계산
 */
class Solution {

  public String solution(int n, int t, int m, int p) {
    String answer = "";
    int idx = 1;
    for (int i = 0; i <= 100001; i++) {
      String s = Integer.toString(i, n);
      for (String ss : s.split("")) {
        if (idx == p) {
          p += m;
          answer += ss.toUpperCase();
          t -= 1;
          if (t == 0) {
            return answer;
          }
        }
        idx++;
      }
    }
    return answer;
  }
}