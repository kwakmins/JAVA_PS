import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {

            sb.append("Scenario ").append(t).append(":").append("\n");

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = -1;
            }

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
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static int find(int x) {

        if (arr[x] == -1) {
            return x;
        }

        return arr[x] = find(arr[x]);
    }

    static void union(int x, int y) {

        int findX = find(x);
        int findY = find(y);

        if (findX == findY) {
            return;
        }

        arr[findX] = findY;

    }
}