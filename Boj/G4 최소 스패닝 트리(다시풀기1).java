import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);

        arr = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < E; i++) {

            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            pq.add(new int[]{a, b, c});
        }

        int sum = 0;
        while (!pq.isEmpty()) {

            int[] poll = pq.poll();
            int a = poll[0];
            int b = poll[1];
            int c = poll[2];

            if (find(a) != find(b)) {
                sum += c;
                union(a, b);
            }

        }

        System.out.println(sum);
    }

    static int find(int x) {

        if (arr[x] == -1) {
            return x;
        }

        return arr[x] = find(arr[x]);
    }

    static boolean union(int x, int y) {

        int findX = find(x);
        int findY = find(y);

        if (findX == findY) {
            return true;
        }

        arr[findX] = findY;
        return false;
    }
}