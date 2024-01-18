import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * G3 아기 상어 - https://www.acmicpc.net/problem/16236
 * BFS,구현 - 상어가 자기보다 작은 물고기를 먹을 수 있을때, 거리가 가장 가깝고,가장 위쪽,가장 왼쪽 먼저 먹을 때 최대 먹을 수 있을 만큼 먹는 시간 구하기
 *
 * 1. 이동할 수 있으면 이동하고, 우선순위 큐로 가깝고,위쪽,왼쪽 순으로 저장.
 * 2. 이동을 한 위치가 먹을 수 있으면, 이전 큐 초기화 + 크기증가 로직 + 시간 저장.
 * 3. 이동할 수 없으면 저장한 시간 출력.
 *
 * @!!! 가장 위쪽 왼쪽을 방문 순서로 해결하려했음(dx,dy로) -> 꼬일려나? 의문만 가졌었음.
 */
public class Main {

    static int[] dx = {0, -1, 1, 0}; // 지나갈 수 없는 경우가 생겨 순서 꼬여 의미 없음...
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int startX = 0, startY = 0, size = 2, cnt = 0;
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 9) {
                    startX = j;
                    startY = i;
                }
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            } else {
                return o1[2] - o2[2];
            }
        });

        q.add(new int[]{startY, startX, 0});
        int[][] visit = new int[N + 1][N + 1];
        board[startY][startX] = 0;
        visit[startY][startX] = 1;
        int answer = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[1];
            int y = temp[0];
            int time = temp[2];

            if (board[y][x] < size && board[y][x] != 0) {
                board[y][x] = 0;
                visit = new int[N + 1][N + 1];
                visit[y][x] = 1;
                q.clear();

                if (cnt + 1 == size) {
                    cnt = 0;
                    size++;
                } else {
                    cnt++;
                }

                answer = time;
            }

            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];
                if (ax < N && ay < N && ax >= 0 && ay >= 0 &&
                    visit[ay][ax] == 0 && board[ay][ax] <= size
                ) {
                    visit[ay][ax] = 1;
                    q.add(new int[]{ay, ax, time + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
