import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Node {

        public int value;
        public int index;

        public Node(int i, int v) {
            this.index = i;
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]), d = Integer.parseInt(line[1]), c = Integer.parseInt(line[2]);

            List<Node>[] list = new List[n + 1];
            int[] dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                dist[i] = 10000001;
            }
            dist[c] = 0;

            for (int i = 0; i < d; i++) {
                line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]), s = Integer.parseInt(line[2]);
                list[b].add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
            pq.add(new Node(c, 0));

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (dist[node.index] < node.value) {
                    continue;
                }

                for (Node child : list[node.index]) {

                    if (dist[child.index] > dist[node.index] + child.value) {

                        dist[child.index] = dist[node.index] + child.value;
                        pq.add(new Node(child.index, dist[child.index]));
                    }
                }
            }

            int cnt = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == 10000001) {
                    continue;
                }

                cnt++;
                max = Math.max(max, dist[i]);
            }

            System.out.println(cnt + " " + max);
        }
    }
}

