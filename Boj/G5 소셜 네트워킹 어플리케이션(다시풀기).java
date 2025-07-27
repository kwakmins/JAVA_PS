import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parents;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int T = t;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            sb.append("Scenario ").append(T - t).append(":").append('\n');

            int n = Integer.parseInt(br.readLine());
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = -1;
            }

            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                if (find(a) == find(b)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int find(int a) {

        if (parents[a] == -1) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return false;
        }

        parents[findA] = findB;
        return true;
    }
}

