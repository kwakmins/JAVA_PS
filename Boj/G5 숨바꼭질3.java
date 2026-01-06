import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        // 0 위치, 1 시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] visit = new boolean[100001];

//        visit[N] = true;
        pq.add(new int[]{N, 0});

        while (!pq.isEmpty()) {

            int[] poll = pq.poll();
            int loc = poll[0];
            int time = poll[1];

            if (loc == K) {
                System.out.println(time);
                break;
            }

            visit[loc] = true;

            if (loc - 1 >= 0 && !visit[loc - 1]) {
//                visit[loc - 1] = true;
                pq.add(new int[]{loc - 1, time + 1});
            }
            if (loc + 1 <= 100000 && !visit[loc + 1]) {
//                visit[loc + 1] = true;
                pq.add(new int[]{loc + 1, time + 1});
            }
            if (loc * 2 <= 100000 && !visit[loc * 2]) {
//                visit[loc * 2] = true;
                pq.add(new int[]{loc * 2, time});
            }
        }
    }

    // 0-1 BFS
//    static int bfs01() {
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        deque.offer(n);
//        dist[n] = 0;
//
//        while (!deque.isEmpty()) {
//            int pos = deque.poll();
//
//            if (pos == k) {
//                return dist[pos];
//            }
//
//            // 순간이동 (가중치 0) - 덱의 앞쪽에 추가
//            if (pos * 2 <= 100000 && dist[pos * 2] > dist[pos]) {
//                dist[pos * 2] = dist[pos];
//                deque.offerFirst(pos * 2);  // 앞쪽에 추가
//            }
//
//            // 걷기 (가중치 1) - 덱의 뒤쪽에 추가
//            if (pos - 1 >= 0 && dist[pos - 1] > dist[pos] + 1) {
//                dist[pos - 1] = dist[pos] + 1;
//                deque.offerLast(pos - 1);   // 뒤쪽에 추가
//            }
//
//            if (pos + 1 <= 100000 && dist[pos + 1] > dist[pos] + 1) {
//                dist[pos + 1] = dist[pos] + 1;
//                deque.offerLast(pos + 1);   // 뒤쪽에 추가
//            }
//        }
//
//        return dist[k];
//    }
}

