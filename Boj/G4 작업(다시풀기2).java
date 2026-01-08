import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] job = new int[N + 1];
        int[] indegree = new int[N + 1];
        List<Integer>[] indegreeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            indegreeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            job[i + 1] = Integer.parseInt(line[0]);

            for (int j = 2; j < line.length; j++) {
                int x = Integer.parseInt(line[j]);

                indegree[x]++;
                indegreeList[i + 1].add(x);
            }
        }

        int[] result = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                result[i] = job[i];
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int x : indegreeList[poll]) {
                indegree[x]--;
                result[x] = Math.max(result[x], result[poll] + job[x]);

                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);

    }
}

