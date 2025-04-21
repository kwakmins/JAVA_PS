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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] nodeList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            nodeList[from].add(new Node(to, cost));
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        int[] prev = new int[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node pollNode = pq.poll();

            if (dist[pollNode.idx] < pollNode.value) {
                continue;
            }

            for (Node node : nodeList[pollNode.idx]) {

                if (dist[pollNode.idx] + node.value < dist[node.idx]) {
                    prev[node.idx] = pollNode.idx;
                    dist[node.idx] = dist[pollNode.idx] + node.value;
                    pq.add(new Node(node.idx, dist[node.idx]));
                }
            }

        }

        System.out.println(dist[end]);

        List<Integer> resultList = new ArrayList<>();

        int temp = end;
        while (temp != start) {

            resultList.add(temp);
            temp = prev[temp];
        }
        resultList.add(start);

        System.out.println(resultList.size());
        StringBuilder sb = new StringBuilder();

        for (int i = resultList.size() - 1; i >= 0; i--) {
            sb.append(resultList.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}