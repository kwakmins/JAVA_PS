import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Node {

        int x;
        int value;

        public Node(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        List<Node>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        line = br.readLine().split(" ");
        int from = Integer.parseInt(line[0]);
        int to = Integer.parseInt(line[1]);

        int[] dist = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
        pq.add(new Node(from, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {

            Node poll = pq.poll();
            int idx = poll.x;
            int value = poll.value;

            if (dist[idx] > value) {
                continue;
            }

            for (Node next : list[idx]) {
                if (dist[next.x] < Math.min(value, next.value)) {
                    dist[next.x] = Math.min(value, next.value);
                    pq.add(new Node(next.x, Math.min(value, next.value)));
                }
            }
        }

        System.out.println(dist[to]);
    }
}

