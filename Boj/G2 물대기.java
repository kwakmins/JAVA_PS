import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        parents[0] = -1;
        for (int i = 1; i <= N; i++) {

            int a = Integer.parseInt(br.readLine());

            pq.add(new int[]{0, i, a});

            parents[i] = -1;
        }

        int[][] values = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {

            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                values[i][j + 1] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.add(new int[]{i, j, values[i][j]});
            }
        }

        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {

            // 404ms -> 344ms
            if (cnt == N) {
                break;
            }

            int[] poll = pq.poll();

            int a = poll[0];
            int b = poll[1];
            int value = poll[2];

            // 328ms
            if (union(a, b)) {
                sum += value;
                cnt++;
            }

            // 344ms
//            if (find(a) == find(b)) {
//                continue;
//            }
//
//            union(a, b);
//            sum += value;
//            cnt++;
        }

        System.out.println(sum);
    }

    static int find(int x) {

        if (parents[x] == -1) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {

        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false;
        }

        parents[parentX] = parentY;
        return true;
    }

}