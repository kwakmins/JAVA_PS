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

        List<Integer>[] board = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            board[a].add(b);
            board[b].add(a);
        }

        boolean[] visit = new boolean[N + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visit[1] = true;
        int max = 0;
        List<Integer> sameList = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int node = poll[0];
            int value = poll[1];

            for (int a : board[node]) {
                if (visit[a]) {
                    continue;
                }
                visit[a] = true;

                if (max < value + 1) {
                    sameList = new ArrayList<>();
                    sameList.add(a);

                    max = value + 1;
                } else if (max == value + 1) {
                    sameList.add(a);
                }

                q.add(new int[]{a, value + 1});
            }
        }

        int min = sameList.stream().mapToInt(i -> i).min().getAsInt();
        
        System.out.println(min + " " + max + " " + sameList.size());
    }
}