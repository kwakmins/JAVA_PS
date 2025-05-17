import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int K = Integer.parseInt(br.readLine());

        List<int[]>[] nodeList = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);

            nodeList[u].add(new int[]{v, w});
        }

        int[] dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            int v = poll[0];
            int w = poll[1];

            if (dist[v] < w) {
//            if (dist[v] <= w && w != 0) { // 같아도 진행해야해서 틀림. (이는 밑에서 dist[] 를 갱신해서 바로 빠져나감)
                continue;
            }

            for (int[] node : nodeList[v]) {
                int nodeV = node[0];
                int nodeW = node[1];

                if (dist[nodeV] > dist[v] + nodeW) {
                    dist[nodeV] = dist[v] + nodeW;
                    pq.add(new int[]{nodeV, dist[v] + nodeW});
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