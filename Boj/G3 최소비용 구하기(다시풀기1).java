import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

    static class Node {

        int idx;
        int value;
        List<Integer> route = new ArrayList<>();

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public List<Integer> getRoute() {
            return new ArrayList<>(route);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list[a].add(new Node(b, c));
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        List<Integer>[] route = new List[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            route[i] = new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        Node startNode = new Node(start, 0);
        startNode.route.add(start);
        pq.add(startNode);

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (dist[current.idx] < current.value) {
                continue;
            }

            for (Node next : list[current.idx]) {
                if (dist[next.idx] > current.value + next.value) {
                    dist[next.idx] = current.value + next.value;
                    List<Integer> getRoute = current.getRoute();
                    getRoute.add(next.idx);
                    route[next.idx] = getRoute;

                    Node newNode = new Node(next.idx, dist[next.idx]);
                    newNode.route = getRoute;
                    pq.add(newNode);
                }
            }

        }

        System.out.println(dist[end]);
        System.out.println(route[end].size());
        System.out.println(route[end].stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

