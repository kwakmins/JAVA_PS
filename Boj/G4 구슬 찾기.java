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

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int limit = (N + 1) / 2;

        List<Integer>[] childList = new List[N + 1];
        List<Integer>[] parentsList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            childList[i] = new ArrayList<>();
            parentsList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            childList[a].add(b);
            parentsList[b].add(a);
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {

            boolean[] visit = new boolean[N + 1];
            visit[i] = true;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);

            int childCnt = 0;
            while (!q.isEmpty()) {

                int poll = q.poll();

                for (int a : childList[poll]) {
                    if (!visit[a]) {
                        visit[a] = true;
                        q.add(a);
                        childCnt++;
                    }
                }
            }

            visit = new boolean[N + 1];
            visit[i] = true;

            q = new ArrayDeque<>();
            q.add(i);

            int parentsCnt = 0;
            while (!q.isEmpty()) {

                int poll = q.poll();

                for (int a : parentsList[poll]) {
                    if (!visit[a]) {
                        visit[a] = true;
                        q.add(a);
                        parentsCnt++;
                    }
                }
            }

            if (parentsCnt >= limit || childCnt >= limit) {
                result++;
            }
        }

        System.out.println(result);
    }
}

