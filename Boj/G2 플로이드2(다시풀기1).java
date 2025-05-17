import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int maxValue = 10000001;
        int[][] dist = new int[n + 1][n + 1];
        int[][] distRoute = new int[n + 1][n + 1];

        // 갱신할 때,참조중인 곳도 갱신되어야하는데, 몰라서 안됨
//        List<Integer>[][] distList = new List[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                dist[i][j] = maxValue;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            if (dist[a][b] < c) {
                continue;
            }

            dist[a][b] = c;
            distRoute[a][b] = b;
        }

        for (int t = 1; t <= n; t++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    // <= 안하고 < 하면 같아도 갱신 ==> disRoute 가 이미 갱신된 곳에 재 갱신 -> 0으로됨
                    if (dist[i][j] <= dist[i][t] + dist[t][j]) {
                        continue;
                    }
                    dist[i][j] = dist[i][t] + dist[t][j];

                    distRoute[i][j] = distRoute[i][t];

//                    distList[i][j] = new ArrayList<>();
//                    distList[i][j].add(i);
//                    distList[i][j].add(t);
//                    distList[i][j].addAll(distList[t][j]);
                }
            }
        }

        StringBuilder resultSb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == maxValue) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            resultSb.append(sb);
            if (i != n) {
                resultSb.append("\n");
            }
        }
        System.out.println(resultSb);

        resultSb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (distRoute[i][j] == 0) {
                    sb.append(0).append("\n");
                } else {

                    Queue<Integer> q = new ArrayDeque<>();
                    List<Integer> routeList = new ArrayList<>();

                    routeList.add(i);
                    q.add(distRoute[i][j]);

                    while (!q.isEmpty()) {

                        int poll = q.poll();
                        routeList.add(poll);

                        if (poll == j) {
                            break;
                        }

                        q.add(distRoute[poll][j]);
                    }
                    sb.append(routeList.size()).append(" ");
                    for (int a : routeList) {
                        sb.append(a).append(" ");
                    }

                    sb.append("\n");
                }
            }
            resultSb.append(sb);
        }
        System.out.println(resultSb);
    }
}