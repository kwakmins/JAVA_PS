import java.util.PriorityQueue;

/**
 * LV3 야근 지수 https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * 우선순위 큐,그리드 - 가장 큰수를 1씩 계속 빼는 문제
 *
 * 우선순위 큐로 가장 큰 값을 빼고, -1해서 다시 넣기
 */
class Solution {

  public long solution(int n, int[] works) {
    long answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int i : works) {
      pq.add(i);
    }
    for (int i = 0; i < n; i++) {
      int temp = pq.poll();
      if (temp == 0) {
        break;
      }
      pq.add(temp - 1);
    }
    for (int i : pq) {
      answer += i * i;
    }
    return answer;
  }
}