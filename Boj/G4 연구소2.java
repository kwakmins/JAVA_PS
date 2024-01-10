import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * G4 연구소2 - https://www.acmicpc.net/problem/17141
 * BFS + Comb - 인접한 공간을 감염시키는 바이러스를 놓을 수 있는 공간이 있을 때, 모든 공간을 감염시킬 수 있느 최소 시간
 *
 * 바이러스를 놓을 수 있는 경우의 수 Comb로 경우의 수 마다 BFS로 최소 시간 구하면됨.
 *
 * 시간복잡도
 * M<=10이므로 일부 빈칸 ( <= 10) 인 것 중에서 M개를 고르고 -> 최대 2^10
 * 바이러스가 상하좌우로 N<=50인 칸을 가중치 1로 움직이고 -> 최대 O(N^2)
 * => 2^10 * N^2 => 1024 * 2500 = 2500000
 */
public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] board;
    static int[] visit;
    static int[][] visit2;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        board = new int[N][N];
        visit2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        }
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 2) {
                    list.add(new int[]{i, j, 0});
                }
            }
        }
        visit = new int[list.size()];
        comb(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void comb(int deep, int cnt) {
        if (deep == list.size() || cnt == M) {
            if (cnt == M) {
                visit2 = new int[N][N];
                bfs();
            }
            return;
        }

        visit[deep] = 1;
        comb(deep + 1, cnt + 1);
        visit[deep] = 0;
        comb(deep + 1, cnt);
    }
    // comb 다른 방식
//    static void comb(int deep, int cnt) {
//        if (cnt == M) {
//            visit2 = new int[N][N];
//            bfs();
//            return;
//        }
//
//        for (int i = deep; i < list.size(); i++) {
//            if (visit[i] == 0) {
//                visit[i] = 1;
//                comb(i + 1, cnt + 1);
//                visit[i] = 0;
//            }
//        }
//    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 1) {
                q.add(list.get(i));
                visit2[list.get(i)[0]][list.get(i)[1]] = 1;
            }
        }
        int max = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[1];
            int y = temp[0];
            int cnt = temp[2];

            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i];
                int ay = y + dy[i];

                if (ax >= 0 && ay >= 0 && ax < N && ay < N) {
                    if (board[ay][ax] != 1 && visit2[ay][ax] == 0) {
                        visit2[ay][ax] = 1;
                        max = Math.max(cnt + 1, max);
                        q.add(new int[]{ay, ax, cnt + 1});
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 1 && visit2[i][j] == 0) {
                    return;
                }
            }
        }
        answer = Math.min(max, answer);

    }
}
