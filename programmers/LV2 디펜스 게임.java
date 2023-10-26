import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LV2 디펜스 게임 https://school.programmers.co.kr/learn/courses/30/lessons/142085
 *
 * 그리드 - 방어권 잘 사용해서, 디펜스게임에서 최대로 갈 수 있는 라운드 구하기
 *
 * 라운드를 막을 수 없을 때 마다, 방어권을 소모하고, pq.poll()을 통해 가장 큰 값을 빼고 넣어 최적으로 사용.
 *
 * @!!! 우선순위 큐로 제일 ~~값 간단하게 제거 가능
 */
class Solution {

  public int solution(int n, int k, int[] enemy) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int sum = 0;
    for (int i = 0; i < enemy.length; i++) {
      if (sum + enemy[i] > n) {
        if (k > 0) {
          k--;
          pq.add(enemy[i]);
          sum += enemy[i];
          sum -= pq.poll();
          answer++;
        } else {
          return answer;
        }
      } else {
        pq.add(enemy[i]);
        sum += enemy[i];
        answer++;
      }

    }
    return answer;
  }
}