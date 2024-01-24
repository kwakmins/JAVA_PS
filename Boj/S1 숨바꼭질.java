import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * S1 숨바꼭질 - https://www.acmicpc.net/problem/6118
 * BFS,다익스트라 - 1에서부터 가장 먼 거리에 있는 노드의 크기,개수,번호 구하기. (거리는 1로 고정)
 *
 * 가중치가 1이라서 BFS로 풀어도 됨.
 *
 * @!!! 가중치가 1이라도 PQ로 써야 빠름!
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] dis = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[1] = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int x : list[poll]) {
                if (dis[x] > dis[poll] + 1) {
                    dis[x] = dis[poll] + 1;
                    q.add(x);
                }
            }
        }
        int max = 0, cnt = 0, idx = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (max < dis[i]) {
                max = dis[i];
                cnt = 1;
                idx = i;
            } else if (max == dis[i]) {
                cnt++;
            }
        }
        System.out.println(idx + " " + max + " " + cnt);
    }
}
