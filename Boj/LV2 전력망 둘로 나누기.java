import java.util.ArrayList;
import java.util.List;

/**
 * LV2 전력망 둘로 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/86971?language=java#
 * 완전탐색(트리) - 모두 연결된 한 트리에 한 간선을 자를 때, 두 트리의 크기가 최솟값인 수 구하기
 *
 * 모든 간선을 자르고, 방문 노드 수 차이 계산.
 */
class Solution {

  boolean[] visit;
  List<Integer>[] list;
  int temp = 0;

  public int solution(int n, int[][] wires) {
    int answer = Integer.MAX_VALUE;
    visit = new boolean[n + 1];
    list = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int[] wire : wires) {
      list[wire[0]].add(wire[1]);
      list[wire[1]].add(wire[0]);
    }
    for (int[] wire : wires) {
      list[wire[0]].remove(Integer.valueOf(wire[1]));
      list[wire[1]].remove(Integer.valueOf(wire[0]));

      visit = new boolean[n + 1];
      temp = 0;

      dfs(1);
      int a = temp;
      int b = 0;
      for (int i = 2; i <= n; i++) {
        if (!visit[i]) {
          temp = 0;
          dfs(i);
          b = temp;
        }
      }
      answer = Math.min(answer, Math.abs(a - b));
      if (answer == 0) {
        return answer;
      }

      list[wire[0]].add(wire[1]);
      list[wire[1]].add(wire[0]);
    }

    return answer;
  }

  void dfs(int x) {
    temp++;
    visit[x] = true;
    for (int i : list[x]) {
      if (!visit[i]) {
        dfs(i);
      }
    }
  }
}