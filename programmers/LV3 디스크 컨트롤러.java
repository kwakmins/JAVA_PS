import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @LV3 디스크 컨트롤러 - https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * 우선순위 큐 - 어느 시점에서 소요되는 시간이 있는 작업에서 한 작업 씩만 가능할 때, 가장 짧은 평균 걸린 시간 구하기
 *
 * 가능한 시간대에서 소요되는 시간이 가장 짧은 순으로 해야 가장 짧음.
 * 시점순으로 정렬 후, 시간이 짧은 순으로 정렬되는 우선순위 큐로 구현.
 * .
 * @!!! 소요되는 시간이 가장 짧은 순으로 해야하는지 몰랐음.
 * @!!! 두 정렬이 필요하면 우선순위 큐 고려.
 */
class Solution {

  public int solution(int[][] jobs) {
    int answer = 0;
    Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    int idx = 0;
    int cnt = 0;
    int end = 0;
    while (cnt < jobs.length) {
      while (idx < jobs.length && jobs[idx][0] <= end) {
        pq.add(jobs[idx]);
        idx++;
      }

      if (pq.isEmpty()) {
        end = jobs[idx][0];
      } else {
        int[] temp = pq.poll();
        answer += end - temp[0] + temp[1];
        end += temp[1];
        cnt++;
      }
    }
    return answer / jobs.length;
  }
}