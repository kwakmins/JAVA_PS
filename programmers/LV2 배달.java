import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LV2 배달 https://school.programmers.co.kr/learn/courses/30/lessons/12978
 * 다익스트라 -간선 최소길이 구하기.
 *
 * @Param 노드수, 간선 정보, 문제의 길이 조건의 기준
 * @Return 조건에 맞는 노드 총 수
 *
 * 기초적인 다익스트라 문제.
 * - 모든 간선의 정보를 2중 List로 저장
 * - 우선순위 큐(방문한 노드와 거리 저장)와, 거리 배열을 저장.
 * - 큐의 방문한 노드에, 간선의 정보 List로 방문할 곳 모두 queue에 add (이 때, 최소거리 갱신 O or X)
 */
class Solution {

  public int solution(int N, int[][] road, int K) {
    int answer = 0;
    List<List<Node>> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(new ArrayList<>());
    }

    for (int[] r : road) {
      list.get(r[0] - 1).add(new Node(r[1] - 1, r[2]));
      list.get(r[1] - 1).add(new Node(r[0] - 1, r[2]));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[] dis = new int[N];
    Arrays.fill(dis, Integer.MAX_VALUE);
    dis[0] = 0;
    pq.add(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int weight = node.weight;
      int index = node.index;

      if (weight > dis[index]) {
        continue;
      }

      for (Node n : list.get(index)) {
        if (weight + n.weight < dis[n.index]) {
          dis[n.index] = weight + n.weight;
          pq.add(new Node(n.index, dis[n.index]));
        }
      }
    }
    for (int i : dis) {
      if (i <= K) {
        answer++;
      }
    }

    return answer;
  }


  class Node implements Comparable<Node> {

    int index;
    int weight;

    public Node(int index, int weight) {
      this.index = index;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
      return Integer.compare(this.weight, n.weight);
    }
  }
}