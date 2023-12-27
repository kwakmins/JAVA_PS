import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * G5 난로 - https://www.acmicpc.net/problem/15553
 * 그리드 - K개의 난로로 N번의 시간에서 최소한의 시간만 불키는 문제 (불을 키고있으면 K가 안줄어듬)
 *
 * 총 켜야하는 시간에서 아낄 수 있는 시간을 뺀다
 * -> 가장 많이 아낄 수 있는 시간을 앞과 뒤의 시간차로 구하고, K-1 만큼 그 시간차를 뺄 수 있음.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N, K;
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        if (N == K) {
            System.out.println(N);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N - 1; i++) {
            pq.add(arr[i + 1] - arr[i]);
        }

        int answer = arr[N - 1] - arr[0] + 1;
        for (int i = 1; i < K; i++) {
            answer -= pq.poll() - 1;
        }
        System.out.println(answer);
    }
}
