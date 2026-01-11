import java.util.*;

class Solution {
    public int solution(String[] board) {

        int rx = 0, ry = 0, gx = 0, gy = 0;
        int N = board.length;
        int M = board[0].length();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    rx = j;
                    ry = i;
                }
                if (board[i].charAt(j) == 'G') {
                    gx = j;
                    gy = i;
                }
            }
        }

        boolean[][] visit = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { rx, ry, 0 });
        visit[ry][rx] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int x = poll[0];
            int y = poll[1];
            int value = poll[2];

            if (x == gx && y == gy) {
                return value;
            }

            // 왼쪽
            for (int i = x - 1; i >= -1; i--) {
                if (i == -1 || board[y].charAt(i) == 'D') { // visit 체크하면 D를 뚫고 지나갈 수 있음(break에 안걸림)
                    int nx = i + 1;
                    int ny = y;

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        q.add(new int[] { nx, ny, value + 1 });
                    }
                    break;
                }
            }

            // 오른쪽
            for (int i = x + 1; i <= M; i++) {
                if (i == M || board[y].charAt(i) == 'D') {
                    int nx = i - 1;
                    int ny = y;

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        q.add(new int[] { nx, ny, value + 1 });
                    }
                    break;
                }
            }

            // 위쪽
            for (int i = y - 1; i >= -1; i--) {
                if (i == -1 || board[i].charAt(x) == 'D') {
                    int nx = x;
                    int ny = i + 1;

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        q.add(new int[] { nx, ny, value + 1 });
                    }
                    break;
                }
            }

            // 아래쪽
            for (int i = y + 1; i <= N; i++) {
                if (i == N || board[i].charAt(x) == 'D') {
                    int nx = x;
                    int ny = i - 1;

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        q.add(new int[] { nx, ny, value + 1 });
                    }
                    break;
                }
            }
        }

        return -1;
    }
}