import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<Integer>[] board;

    static int[] value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        board = new List[N + 1];
        value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            board[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {

            line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            board[a].add(b);
            board[b].add(a);
        }

        value[1] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int a = poll[0];
            int dept = poll[1];

            for (int x : board[a]) {

                if (value[x] == 0) {

                    value[x] = dept + 1;
                    q.add(new int[]{x, dept + 1});
                }

            }

        }

        int max = 0;
        int cnt = 0;
        int num = 0;
        for (int i = 2; i <= N; i++) {

            if (max < value[i]) {
                max = value[i];
                cnt = 1;
                num = i;
            } else if (max == value[i]) {
                cnt++;
            }

        }

        System.out.println(num + " " + max + " " + cnt);

    }

    // 최단 거리라서 dfs x
//    static void dfs(int x, int dept) {
//
//        for (int a : board[x]) {
//
//            if (value[a] == 0) {
//                value[a] = dept + 1;
//                dfs(a, dept + 1);
//            }
//
//        }
//
//    }
}