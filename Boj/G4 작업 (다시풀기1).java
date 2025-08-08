import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] value = new int[N + 1];
        List<Integer>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[N + 1];

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            value[i] = line[0];

            int m = line[1];
            if (m == 0) {
                q.add(i);
            }
            for (int j = 2; j < m + 2; j++) {
                indegree[i]++;
                graph[line[j]].add(i);
            }
        }

        int[] maxTime = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            maxTime[i] = value[i];
        }

        while (!q.isEmpty()) {

            int now = q.poll();

            for (Integer next : graph[now]) {

                if (--indegree[next] == 0) {
                    q.add(next);
                }

                maxTime[next] = Math.max(maxTime[next], maxTime[now] + value[next]);
            }
        }

        System.out.println(Arrays.stream(maxTime).max().getAsInt());

    }
}

