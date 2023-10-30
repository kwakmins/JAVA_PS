import java.util.ArrayList;
import java.util.List;

/**
 * LV3 네트워크 https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * DFS/BFS - 연결되지 않은 노드 수 구하기
 *
 * 방문하지 않은 노드를 방문할 때, dfs로 연결된 노드 모두 방문 처리
 *
 * @!!! List<List < Integer>> 보단 List<Integer>[]가 더 편하다
 */
class Solution {

  List<Integer>[] list;
  int[] visit;

  public int solution(int n, int[][] computers) {
    int answer = 0;
    visit = new int[n];
    list = new List[n];
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < computers.length; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && computers[i][j] == 1) {
          list[i].add(j);
          list[j].add(i);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (visit[i] == 0) {
        answer++;
        dfs(i);
      }
    }

    return answer;
  }

  void dfs(int n) {
    for (int i : list[n]) {
      if (visit[i] == 0) {
        visit[i] = 1;
        dfs(i);
      }
    }
  }
}