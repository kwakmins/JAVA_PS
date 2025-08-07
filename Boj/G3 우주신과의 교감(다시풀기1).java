import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] parents;

    static class Route implements Comparable<Route> {

        int a;
        int b;
        double value;

        public Route(int a, int b, double value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        @Override
        public int compareTo(Route o) {
            return Double.compare(value, o.value);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            if (union(Integer.parseInt(line[0]), Integer.parseInt(line[1]))) { // union
                cnt++;
            }
        }

        List<Route> routeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) { // j= i+1 부터 하면 시간 단축

//                if (i == j) {
//                    continue;
//                }

                int[] a = list.get(i);
                int[] b = list.get(j);

                routeList.add(new Route(i + 1, j + 1,
                        Math.sqrt(Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2)))); // i+1, j+1 해야함..
            }
        }

        Collections.sort(routeList);

        double sum = 0;
        for (int i = 0; i < routeList.size(); i++) {

            if (cnt == N - 1) {
                break;
            }

            Route route = routeList.get(i);

            if (union(route.a, route.b)) {
                cnt++;
                sum += route.value;
            }

        }

        System.out.println(String.format("%.2f", sum));

    }

    static int find(int a) {

        if (parents[a] == -1) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {

        int aParents = find(a);
        int bParents = find(b);

        if (aParents == bParents) {
            return false;
        }

        parents[aParents] = bParents;

        return true;

    }

}

