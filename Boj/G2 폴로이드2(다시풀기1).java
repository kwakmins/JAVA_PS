import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX_VALUE = 9900001;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];
        int[][] tracking = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], MAX_VALUE);
            dist[i][i] = 0;
        }

        while (m-- > 0) {

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            dist[a][b] = Math.min(dist[a][b], c); // '시작 도시와 도착 도시가 같은 경우는 없다.'는 dist[a][a]인 경우가 없다는 뜻임
            tracking[a][b] = b;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
//                        tracking[i][j] = k; // 또 실수. 이러면 기존 최단거리 루트 무시하고 직행해버림 (k까지 가는데 z를 거쳐서 가는게 이득이면 i->z->k 여야함)
                        tracking[i][j] = tracking[i][k];
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == MAX_VALUE) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    sb.append(0).append("\n");
                    continue;
                }

                int cnt = 0;
                String temp = "";
                int x = i;

                while (true) {
                    if (x == 0) {
                        break;
                    }

                    temp += x + " ";
                    cnt++;

                    if (x == j) {
                        break;
                    }
                    x = tracking[x][j];
                }
                sb.append(cnt).append(" ").append(temp).append("\n");

            }
        }

        System.out.println(sb);
    }
}

