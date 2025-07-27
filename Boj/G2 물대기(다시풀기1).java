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
        for (int i = 0; i <= N; i++) {
            parents[i] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            pq.add(new int[]{i, N, value});
        }

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                if (j == i) {
                    continue;
                }

                int value = Integer.parseInt(line[j]);
                pq.add(new int[]{i, j, value});
            }
        }

        int sum = 0;
        int cnt = 0;

        while (cnt < N) {
            int[] poll = pq.poll();

            if (union(poll[0], poll[1])) {
                cnt++;
                sum += poll[2];
            }
        }

        System.out.println(sum);
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