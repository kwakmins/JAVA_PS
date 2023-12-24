import java.util.Arrays;

/**
 * LV3 입국심사 - https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 이분탐색, Under Bound - N명의 사람이 모두 입국심사를 거치는 가장 적은 시간 구하기.
 *
 * 10억이라 for문 X -> 시간 이분탐색으로 N명 조건 만족하게 구하기 -> 여러개 있으면 제일 작은 시간 구하기(UnderBound)
 *
 * @!!! 연산은 무조건 캐스팅 해주자.
 */
class Solution {

  public long solution(int n, int[] times) {
    long answer = 0;
    Arrays.sort(times);
    long start = 0;
    long end = (long) times[0] * (long) n; //연산에서 int 초과될 수 있음.
    while (start < end) {
      long mid = (start + end) / 2;

      long x = 0;
      for (int time : times) {
        x += mid / time;
      }
      if (x < n) { // 찾는 수가 같아도 줄어듬 (under Bound)
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return end;
  }
}