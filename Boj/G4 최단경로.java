import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * G4 최단경로 https://www.acmicpc.net/problem/1753
 * 다익스트라 - 방향없는 다익스트라.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    int v = Integer.parseInt(line[0]);
    int e = Integer.parseInt(line[1]);
    int start = Integer.parseInt(bf.readLine()) - 1;

    List<Node>[] list = new List[v];
    for (int i = 0; i < v; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < e; i++) {
      String[] line2 = bf.readLine().split(" ");
      int u = Integer.parseInt(line2[0]) - 1;
      int r = Integer.parseInt(line2[1]) - 1;
      int w = Integer.parseInt(line2[2]);
      list[u].add(new Node(r, w));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(
        (a, b) -> a.value - b.value
    );
    pq.add(new Node(start, 0)); // 시작노드에서 상대 노드에 대한 정보
    int[] dis = new int[v];
    for (int i = 0; i < v; i++) {
      dis[i] = Integer.MAX_VALUE;
    }
    dis[start] = 0;
    while (!pq.isEmpty()) {
      Node poll = pq.poll(); // 시작 노드랑 연결된 노드 가져오기

      if (dis[poll.idx] < poll.value) { // 이미 더 짧은 거리가 있음
        continue;
      }

      for (Node n : list[poll.idx]) { // 연결된 노드와 또 연결된 모든 노드 분석
        if (dis[n.idx] > poll.value + n.value) { // 연결된 노드로 인해, 새롭게 생기는 거리 계산이 더 짧은지 확인
          dis[n.idx] = poll.value + n.value; // 갱신
          pq.add(new Node(n.idx, +dis[n.idx])); // 새로운 짧은 거리의 노드
        }
      }

    }
    for (int d : dis) {
      if (d == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(d);
      }
    }
  }

  static class Node {

    int idx, value;

    Node(int idx, int value) {
      this.idx = idx;
      this.value = value;
    }
  }
}
