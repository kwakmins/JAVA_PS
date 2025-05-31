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
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        List<int[]>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        int[] dist = new int[N + 1];
        dist[start] = 1000000001;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.add(new int[]{start, 1000000001});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int idx = poll[0];
            int value = poll[1];

            if (dist[idx] > value) {
                continue;
            }

            for (int[] node : list[idx]) {

                int max = Math.min(value, node[1]); // 헷갈림

                if (dist[node[0]] < max) {
                    dist[node[0]] = max;
                    pq.add(new int[]{node[0], dist[node[0]]});
                }
            }
        }

        System.out.println(dist[end]);
    }
}

