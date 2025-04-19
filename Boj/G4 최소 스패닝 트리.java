import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        parent = new int[V + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            pq.add(new Node(a, b, c));

        }

        int sum = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {

            Node poll = pq.poll();

            int x = poll.from;
            int y = poll.to;

            if (find(x) != find(y)) {

                union(x, y);
                cnt++;
                sum += poll.cost;

            }
            if (cnt == V - 1) {
                break;
            }
        }

        System.out.println(sum);
    }

    static int find(int x) {

        if (parent[x] == 0) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {

        int x = find(a);
        int y = find(b);

        if (x == y) {
            return;
        }

        parent[y] = x;

    }

    static class Node {

        public int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

}