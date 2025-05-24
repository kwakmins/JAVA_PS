import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            pq.add(new int[]{a, b, c});
        }

        int cnt = 0;
        int result = 0;
        int max = 0;

        while (!pq.isEmpty()) {

            if (cnt == N - 1) {
                break;
            }

            int[] poll = pq.poll();

            int a = poll[0];
            int b = poll[1];
            int c = poll[2];

            if (union(a, b)) {

                result += c;
                max = Math.max(max, c);
                cnt++;
            }
        }

        System.out.println(result - max);
    }


    static int find(int x) {

        if (parents[x] == -1) {
            return x;
        }

        return parents[x] = find(parents[x]);
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

