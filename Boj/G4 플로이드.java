import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G4 플로이드 - https://www.acmicpc.net/problem/11404
 * 플로이드 워셜 - 기본 플로이드 문제. 자기 자신에게 이동은 0처리.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 10000001;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dis[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int value = Integer.parseInt(line[2]);
            dis[start][end] = Math.min(dis[start][end], value);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        dis[i][j] = 0;
                    } else {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dis[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
