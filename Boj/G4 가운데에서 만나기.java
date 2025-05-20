import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (i == j) {
                    continue;
                }

                dist[i][j] = 5000000;
            }
        }

        for (int i = 1; i <= M; i++) {
            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            dist[a][b] = c;
        }

        int K = Integer.parseInt(br.readLine());
        int[] cities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            int cnt = Integer.MIN_VALUE;
            for (int city : cities) {
                cnt = Math.max(cnt, dist[city][i] + dist[i][city]);
            }

            if (cnt < min) {
                resultList = new ArrayList<>();
                min = cnt;
                resultList.add(i);
            } else if (cnt == min) {
                resultList.add(i);
            }
        }

        for (int i : resultList) {
            System.out.print(i + " ");
        }
    }
}

