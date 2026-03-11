import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] route = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(route[i], 1234567);
        }

        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            route[a][b] = 0;
            if (c == 1) {
                route[b][a] = 0;
            } else {
                route[b][a] = 1;
            }
        }

        for (int z = 1; z <= n; z++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        route[i][j] = 0;
                    }

                    route[i][j] = Math.min(route[i][j], route[i][z] + route[z][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);

            int ans = route[s][e];
            System.out.println(ans);
        }
    }

}

