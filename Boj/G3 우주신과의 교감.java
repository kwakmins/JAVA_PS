import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        parents = new int[N + 1];
        int cnt = 0;

        // 0부터 넣어짐
        List<double[]> godList = new ArrayList<>();
        godList.add(new double[]{});
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;

            line = br.readLine().split(" ");

            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);

            godList.add(new double[]{X, Y});
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");

            boolean union = union(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            if (union) { // 중복으로 들어올수도 있어서..
                cnt++;
            }
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[2], b[2]));

        for (int i = 1; i <= N; i++) {
            double[] fromGod = godList.get(i);

            for (int j = i + 1; j <= N; j++) {
                double[] toGod = godList.get(j);

                double v = Math.sqrt(Math.pow(Math.abs(fromGod[0] - toGod[0]), 2) + Math.pow(Math.abs(fromGod[1] - toGod[1]), 2));

                pq.add(new double[]{i, j, v});
                // 양방향일 필요 없을듯 어차피 모든 경로 pq에 넣으니
            }
        }

        double result = 0;
//        int cnt = M
        while (!pq.isEmpty()) {

            if (cnt == N - 1) { // 시간 2배 단축
                break;
            }

            double[] poll = pq.poll();
            int a = (int) poll[0];
            int b = (int) poll[1];

            if (!union(a, b)) {
                continue;
            }

            cnt++;
            result += poll[2];
        }

//        result = (double) Math.round(result * 100) / 100;
        System.out.println(String.format("%.2f", result));
        
    }

    static int find(int a) {
        if (parents[a] == -1) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {

        int parentsA = find(a);
        int parentsB = find(b);

        if (parentsA == parentsB) {
            return false;
        }

        parents[parentsA] = parentsB;
        return true;
    }

}

