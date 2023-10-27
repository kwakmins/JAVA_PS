/**
 * LV2 https://school.programmers.co.kr/learn/courses/30/lessons/12985
 * 구현 - 대진표에서 특정 선수 두명이 만날 때 까지 치리는 경기수 구하기
 *
 * 팀을 식으로 구해서, 같은 팀이 될 때 까지 반복.
 *
 * @!!! 규칙 파악 중요
 */
class Solution {

  public int solution(int n, int a, int b) {
    int answer = 0;
    while (true) {
      a = a / 2 + a % 2; // 홀수를 위해 ((a + 1) / 2)
      b = b / 2 + b % 2;
      answer++;
      if (a == b) {
        break;
      }
    }

    return answer;
  }
}