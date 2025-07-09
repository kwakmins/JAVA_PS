import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        arr = new int[n + 1];
        // 문제가 0부터임..
//        for (int i = 1; i <= n; i++) {
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            if (a == 0) {
                union(b, c);
            } else {
                if (find(b) == find(c)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static int find(int a) {

        if (arr[a] < 0) {
            return a; // 부모면 -1이 아닌 자기 자신 return
        }

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA == findB) {
            return;
        }

        arr[findA] = findB;
    }
}

