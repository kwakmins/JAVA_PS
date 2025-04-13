import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int e = pq.poll() + pq.poll();
            sum += e;
            pq.add(e);
        }
        System.out.println(sum);
    }
}