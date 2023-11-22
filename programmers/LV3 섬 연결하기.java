import java.util.Arrays;

/**
 * @LV3 섬 연결하기 https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 크루스칼 알고리즘 - 모든 간선의 최소신장 구하기
 *
 * @!!! 다익스트라는 한 간선에서 다른 간선의 최소 길이 배열을 구하는것이다.
 */
class Solution {

  public int solution(int n, int[][] costs) {
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    Arrays.sort(costs, (a, b) -> a[2] - b[2]);
    return kruskal(costs, parent);
  }

  void union(int[] parent, int x, int y) {
    x = find(parent, x);
    y = find(parent, y);

    if (x < y) {
      parent[y] = x;
    } else {
      parent[x] = y;
    }
  }

  // 파인드
  int find(int[] parent, int x) {
    if (parent[x] == x) {
      return x;
    } else {
      return find(parent, parent[x]);
    }
  }

  // 크루스칼
  int kruskal(int[][] graph, int[] parent) {
    int cost = 0;
    for (int i = 0; i < graph.length; i++) {
      if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
        cost += graph[i][2];
        union(parent, graph[i][0], graph[i][1]);
      }
    }
    return cost;
  }
}