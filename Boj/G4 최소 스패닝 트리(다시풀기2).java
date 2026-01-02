import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    // 간선
    static class Edge {

        int from;
        int to;
        int value;

        public Edge(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    // union-find의 부모
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);

        // 크루스칼 = 최소부터 연결
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            pq.add(new Edge(a, b, c));
        }

        // union-find로 부모가 아닌것끼리 연결
        parent = new int[V + 1];
        Arrays.fill(parent, -1);

        // 순회 일찍 종료를 위해 모든 간선이 연결되면 종료를 위함
        int cnt = 0;
        int sum = 0;

        // 제일 비용이 작은것부터 순회
        while (!pq.isEmpty()) {
            if (cnt == V - 1) {
                break;
            }

            Edge poll = pq.poll();

            // 합쳐지면 = 연결되면 비용 지불
            if (union(poll.from, poll.to)) {
                sum += poll.value;
                cnt++;
            }
        }

        System.out.println(sum);
    }

    // a의 최상위 부모 찾는 메서드
    static int find(int a) {
        // 최상의 부모면
        if (parent[a] == -1) {
            return a;
        }

        // a의 부모를 최상위 부모로 변경 (다음 접근시 O(1))
        return parent[a] = find(parent[a]);
    }

    // a가족과 b가족을 합치기
    static boolean union(int a, int b) {

        int aParent = find(a);
        int bParent = find(b);

        if (aParent == bParent) {
            return false;
        }

        // aParent 모든 가족을 bParent로 이동됨 == 합쳐짐
        parent[aParent] = bParent;
        return true;
    }

}

