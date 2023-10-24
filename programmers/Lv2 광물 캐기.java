import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LV2 광물캐기 https://school.programmers.co.kr/learn/courses/30/lessons/172927#
 * Greed - 가지고 있는 세가지 도구로 가장 효율적으로 광물을 캐는 문제
 *
 * 각 도구별로 드는 비용을 모두 계산 하여 우선순위 큐를 이용하여 계산
 *
 * @!!! new PriorityQueue<>((a, b) -> b[2] - a[2]); 이렇게 정렬 방식 정할 수 있고, foreach,stream엔 순서 보장x
 * @!!! 자칫하면 DFS문제로 보일 수 있음. 가중치가 있는 경우는 그리드로 생각해보자
 */
class Solution {

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;
    Map<String, int[]> map = new HashMap<>();
    map.put("diamond", new int[]{25, 5, 1});
    map.put("iron", new int[]{5, 1, 1});
    map.put("stone", new int[]{1, 1, 1});

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

    int di = 0, ir = 0, st = 0;
    int picksCnt = Arrays.stream(picks).sum();
    for (int i = 0; i < minerals.length; i++) {

      if (i != 0 && i % 5 == 0) {
        pq.add(new int[]{di, ir, st});
        picksCnt--;
        di = 0;
        ir = 0;
        st = 0;
      }
      if (picksCnt == 0) {
        break;
      }
      int[] tired = map.get(minerals[i]);
      di += tired[2];
      ir += tired[1];
      st += tired[0];
    }
    if (di != 0) {
      pq.add(new int[]{di, ir, st});
    }

    while (!pq.isEmpty()) {
      int[] x = pq.poll();
      if (picks[0] > 0) {
        answer += x[0];
        picks[0]--;
        continue;
      }
      if (picks[1] > 0) {
        answer += x[1];
        picks[1]--;
        continue;
      }
      if (picks[2] > 0) {
        answer += x[2];
        picks[2]--;
        continue;
      }
    }
    return answer;
  }

}