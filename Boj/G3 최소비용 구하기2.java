import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] route = new int[n + 1];
        int[] dist = new int[n + 1];
        List<int[]>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list[a].add(new int[]{b, c});
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            int pollNode = poll[0];
            int cost = poll[1];

            if (dist[pollNode] < cost) {
                continue;
            }

            for (int[] node : list[pollNode]) {
                if (dist[node[0]] > dist[pollNode] + node[1]) {
                    dist[node[0]] = dist[pollNode] + node[1];
                    route[node[0]] = pollNode;
                    pq.add(new int[]{node[0], dist[node[0]]});
                }
            }
        }

        System.out.println(dist[end]);

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> routeList = new ArrayList<>();
        q.add(end);
        while (!q.isEmpty()) {
            int poll = q.poll();

            routeList.add(poll);

            if (route[poll] == start) {
                routeList.add(start);
                break;
            }

            q.add(route[poll]);
        }
        System.out.println(routeList.size());
        Collections.reverse(routeList);
        System.out.println(routeList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

