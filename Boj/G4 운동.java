import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G4 운동 - https://www.acmicpc.net/problem/1956
 * 플로이드 워셜 - 거리에서 순한하는 루트의 최소 길이 구하기.
 *
 * 플로이드 워셜를 구하면 i->?->i 의 최소값이 구하짐.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 4000001;
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int[][] dis = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dis[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int value = Integer.parseInt(line[2]);
            dis[start][end] = Math.min(dis[start][end], value);
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dis[i][i]);
        }
        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
