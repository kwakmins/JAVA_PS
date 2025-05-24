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
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        List<Integer>[] list = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        line = br.readLine().split(" ");

        for (int i = 0; i < line.length; i++) {
            int temp = Integer.parseInt(line[i]);
            if (temp == -1) {
                continue;
            }

            list[temp].add(i + 1);
        }

        int[] values = new int[n + 1];
        for (int j = 0; j < m; j++) {

            line = br.readLine().split(" ");

            int i = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);
            values[i] += w;
        }

        int[] result = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {

            int[] poll = q.poll();
            int index = poll[0];
            int value = poll[1];

            result[index] += value;

            for (int child : list[index]) {
                if (!visit[child]) {
                    visit[child] = true;
                    q.add(new int[]{child, values[child] + value});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

