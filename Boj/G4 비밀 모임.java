import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * G4 비밀 모임 - https://www.acmicpc.net/problem/13424
 * 다익스트라,플로이드 워셜 - M명의 친구가 노드에 위치해있을 때, 서로 모이데 최솟값인 노드 구하기.
 *
 * 친구마다 다익스트라로 거리 구한 뒤, 배열에 저장 -> 모든 노드에 계산한 거리로 최솟값 찾기.
 *
 * @!!! 노드가 1부터 시작이면 -1로 0으로 맞추지 말고 그냥 하는게 편함
 */
public class Main {

    static List<Node>[] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = bf.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);

            board = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                board[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int[] temp = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
                board[temp[0]].add(new Node(temp[1], temp[2]));
                board[temp[1]].add(new Node(temp[0], temp[2]));
            }

            int K = Integer.parseInt(bf.readLine());
            int[] kArr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

            int[][] dis = new int[N + 1][N + 1];
            for (int k : kArr) {
                dis[k] = dij(k);
            }
            int min = Integer.MAX_VALUE;
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int k : kArr) {
                    sum += dis[k][i];
                }
                if (min > sum) {
                    min = sum;
                    answer = i;
                }
            }
            System.out.println(answer);
        }
    }

    static int[] dij(int start) {
        int[] dis = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dis[node.idx] < node.value) {
                continue;
            }

            for (Node n : board[node.idx]) {
                if (dis[n.idx] > node.value + n.value) {
                    dis[n.idx] = node.value + n.value;
                    pq.add(new Node(n.idx, dis[n.idx]));
                }
            }
        }
        return dis;
    }

    static class Node {

        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
