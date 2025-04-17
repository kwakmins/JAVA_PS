import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] board = new int[N + 1];

        for (int i = 0; i < M; i++) {

            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            board[b]++;
            list[a].add(b);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (board[i] == 0) {
                pq.add(i);
            }
        }

        StringBuffer sb = new StringBuffer();

        while (!pq.isEmpty()) {

            int poll = pq.poll();

            sb.append(poll).append(" ");

            for (int p : list[poll]) {

                board[p]--;

                if (board[p] == 0) {
                    pq.add(p);
                }

            }
        }

        System.out.println(sb);


    }

}