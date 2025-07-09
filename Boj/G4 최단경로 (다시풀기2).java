import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static final int INF = 12345678;

    static class Node {

        public int idx;
        public int value;

        public Node(int a, int b) {
            idx = a;
            value = b;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);

        int start = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");

            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);

            list[u].add(new Node(v, w));
        }

        int[] dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node visit = pq.poll();

            if (dist[visit.idx] < visit.value) {
                continue;
            }

            for (Node n : list[visit.idx]) {
                if (dist[n.idx] > visit.value + n.value) {
                    dist[n.idx] = visit.value + n.value;
                    pq.add(new Node(n.idx, dist[n.idx]));
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);

    }
}

