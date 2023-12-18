import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * G5 최소비용 구하기 - https://www.acmicpc.net/problem/1916
 * 다익스트라 - 버스가 길을 이용할 때, A에서 B로 가는 최소 비용 계산
 *
 * 대표적인 다익스트라 문제 (단방향)
 *
 * @!!! 당연히 양방향이라고 생각해서 계속 안됐음.
 */
public class Main {

  static int N, M;
  static List<Node>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    M = Integer.parseInt(bf.readLine());
    list = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      String[] line = bf.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int c = Integer.parseInt(line[2]);
      list[a].add(new Node(b, c));
    }
    int start, end;
    String[] line = bf.readLine().split(" ");
    start = Integer.parseInt(line[0]);
    end = Integer.parseInt(line[1]);

    int[] distance = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      if (distance[node.idx] < node.value) {
        continue;
      }

      for (Node n : list[node.idx]) {
        if (distance[n.idx] > node.value + n.value) {
          distance[n.idx] = node.value + n.value;
          pq.add(new Node(n.idx, distance[n.idx]));
        }
      }
    }

    System.out.println(distance[end]);

  }

  static class Node {

    int idx, value;

    public Node(int x, int y) {
      idx = x;
      value = y;
    }
  }
}
