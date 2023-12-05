/**
 * LV3 가장 긴 팰린드롬 - https://school.programmers.co.kr/learn/courses/30/lessons/12904
 * 구현 - 문자열 s 중 앞 뒤가 같은 문자열 길이 찾기
 *
 * 가장 긴 문자열 순으로 탐색.
 */
class Solution {

  String ss;

  public int solution(String s) {
    int answer = 1;
    ss = s;
    for (int i = s.length(); i >= 1; i--) {
      for (int j = 0; j <= s.length() - i; j++) {
        int start = j;
        int end = j + i - 1;
        if (palind(start, end)) {
          return i;
        }
      }
    }

    return answer;
  }

  boolean palind(int start, int end) {
    while (start <= end) {
      if (ss.charAt(start) != ss.charAt(end)) {
        return false;
      }
      start += 1;
      end -= 1;
    }
    return true;
  }
}