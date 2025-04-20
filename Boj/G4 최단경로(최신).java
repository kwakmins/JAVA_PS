import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Node {

        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int K = Integer.parseInt(br.readLine());

        List<Node>[] nodeList = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);

            nodeList[u].add(new Node(v, w));
        }

        int[] dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {

            // 방문한 노드
            Node poll = pq.poll();

//            if (poll.value >= dist[poll.idx] && poll.value != 0) { 갱신하고 들어오기 때문에 같아도 처리해야함.
            if (poll.value > dist[poll.idx]) {
                continue;
            }
//            dist[poll.idx] = poll.value; 이러면 pq에 진입할 때 갱신되므로, 불필요하게 pq.add -> OOM 발생

            // 연결된 노드 넣기 - 이는 pq를 이용하여, 각 노드당 한번만 될거임 (O(NlogN))
            for (Node node : nodeList[poll.idx]) {

                if (node.value + dist[poll.idx] < dist[node.idx]) {
                    dist[node.idx] = node.value + dist[poll.idx];
                    pq.add(new Node(node.idx, node.value + dist[poll.idx])); // 더 작은 경로 발견 - pq에 넣으면 이전에 넣었던 더 큰 경로는 무시될것임
                }

            }

        }

        for (int i = 1; i <= V; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(dist[i]);
        }
    }

}