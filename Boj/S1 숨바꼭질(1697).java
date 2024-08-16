import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S1 숨바꼭질 - https://www.acmicpc.net/problem/1697
 * BFS - 출발점에서 도착점까지 가는데 최소 시간 구하기
 *
 * @!!! 중복 탐색을 항상 조심하자
 * @!!! 범위를 넘어가는 걸 항상 조심하자.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        int answer = 0;
        boolean[] visit = new boolean[100000000];
        visit[n] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int location = poll[0];
            int cnt = poll[1];

            if (location == m) {
                answer = cnt;
                break;
            }

            if (location + 1 <= 100000 && !visit[location + 1]) {
                q.add(new int[]{location + 1, cnt + 1});
                visit[location + 1] = true;
            }
            if (location - 1 >= 0 && !visit[location - 1]) {
                q.add(new int[]{location - 1, cnt + 1});
                visit[location - 1] = true;
            }
            if (location * 2 <= 100000 && !visit[location * 2]) {
                q.add(new int[]{location * 2, cnt + 1});
                visit[location * 2] = true;
            }
        }

        System.out.println(answer);

    }
}
