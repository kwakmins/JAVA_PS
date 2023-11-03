import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LV3 https://school.programmers.co.kr/learn/courses/30/lessons/72413
 * 다익스트라 - 노드 s에서 시작해서, 노드 a와 노드 b로 각자 가는 최솟값 구하기.
 *
 * 노드들을 i라고 둘 때, s->i + i->a + i->b 중 가장 작은 값 구하면 된다.
 *
 * @!!! 다익스트라에 대한 이해도 부족
 * @!!! 임의로 큰 값을 줄 때, 좀 더 크게 주자
 */
class Solution {

  List<Node>[] list;
  int N;

  public int solution(int n, int s, int a, int b, int[][] fares) {
    int answer = Integer.MAX_VALUE;
    list = new List[n + 1];
    N = n;
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int[] i : fares) {
      list[i[0]].add(new Node(i[1], i[2]));
      list[i[1]].add(new Node(i[0], i[2]));
    }

    int[] aDis = dijk(a);
    int[] bDis = dijk(b);
    int[] sDis = dijk(s);

    for (int i = 1; i <= n; i++) {
      answer = Math.min(answer, sDis[i] + aDis[i] + bDis[i]);
    }

    return answer;
  }


  int[] dijk(int start) {
    int[] dis = new int[N + 1];
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
    Arrays.fill(dis, 3000000); //큰값 주자
    dis[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node temp = pq.poll();

      if (dis[temp.idx] < temp.value) {
        continue;
      }

      for (Node x : list[temp.idx]) {
        if (dis[x.idx] > temp.value + x.value) {
          dis[x.idx] = temp.value + x.value;
          pq.add(new Node(x.idx, temp.value + x.value));
        }
      }
    }
    return dis;
  }

  class Node {

    int idx, value;

    Node(int x, int y) {
      idx = x;
      value = y;
    }
  }
}