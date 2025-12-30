import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int[] parents;

    static class Distance {

        int a, b;
        double value;

        public Distance(int a, int b, double value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        PriorityQueue<Distance> pq = new PriorityQueue<>((a, b) -> Double.compare(a.value, b.value));

        List<int[]> list = new ArrayList<>();
        while (N-- > 0) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            list.add(new int[]{x, y});
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                int[] a = list.get(i);
                int[] b = list.get(j);

                double d = Math.sqrt(java.lang.Math.pow((double) a[0] - b[0], 2) + java.lang.Math.pow((double) a[1] - b[1], 2));

                pq.add(new Distance(i + 1, j + 1, d));
            }
        }

        int cnt = 0;

        while (M-- > 0) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            if (union(a, b)) {
                cnt++;
            }
        }

        double result = 0;
        while (!pq.isEmpty()) {

            if (cnt == N - 1) {
                break;
            }

            Distance poll = pq.poll();
            if (union(poll.a, poll.b)) {
                result += poll.value;
                cnt++;
            }

        }

//        System.out.println(Math.round(result * 100.0) / 100.0);
        String formatResult = String.format("%.2f", result);
        System.out.println(formatResult);

    }

    static int find(int a) {
        if (parents[a] == -1) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {

        int aParent = find(a);
        int bParent = find(b);

        if (aParent == bParent) {
            return false;
        }

        parents[aParent] = bParent;
        return true;
    }
}

