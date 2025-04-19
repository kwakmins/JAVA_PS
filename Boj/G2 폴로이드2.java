import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int[][] route = new int[n + 1][n + 1];
        int maxValue = 987654321;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = maxValue;
            }
        }

        for (int i = 0; i < m; i++) {

            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            arr[a][b] = Math.min(arr[a][b], c);
            route[a][b] = b;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int z = 1; z <= n; z++) {

                    if (arr[j][z] > arr[j][i] + arr[i][z]) {
                        arr[j][z] = arr[j][i] + arr[i][z];
                        //route[j][z] = i; i까지 가는 것도 route 갱싱 되어 있을 수 있음
                        route[j][z] = route[j][i];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == maxValue) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (route[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }

                List<Integer> list = new ArrayList<>();

                Queue<Integer> q = new LinkedList<>();
                q.add(route[i][j]);

                while (!q.isEmpty()) {
                    Integer poll = q.poll();
                    list.add(poll);

                    if (poll == j) {
                        break;
                    }

                    q.add(route[poll][j]);
                }

                sb.append(list.size() + 1).append(" ").append(i).append(" ");

                for (int l : list) {
                    sb.append(l).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

}