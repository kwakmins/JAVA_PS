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

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        List<Integer>[] tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            tree[a].add(b);
        }

        int[] sum = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visit = new boolean[N + 1];

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visit[i] = true; // 아..

            while (!q.isEmpty()) {
                Integer poll = q.poll();

                for (int a : tree[poll]) {

                    if (visit[a]) {
                        continue;
                    }

                    q.add(a);
                    visit[a] = true;
                    sum[a]++;
                    max = Math.max(max, sum[a]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (sum[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }

}