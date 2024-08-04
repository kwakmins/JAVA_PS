import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S1 그림 - https://www.acmicpc.net/problem/1926
 * BFS - 군집 크기 및 개수 구하기
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = bf.readLine().split(" ");
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] visit = new int[n][m];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int count = 0;
        int maxWidth = 0;

        for (int i = 0; i < n; i++) {
            int tempWidth = 0;

            for (int j = 0; j < m; j++) {
                if (board[i][j].equals("1") && visit[i][j] == 0) {
                    q.add(new int[]{i, j});
                    tempWidth = 1;
                    count++;
                    visit[i][j] = 1;
                }

                while (!q.isEmpty()) {
                    int[] poll = q.poll();
                    int ax = poll[1];
                    int ay = poll[0];

                    for (int k = 0; k < 4; k++) {
                        int x = ax + dx[k];
                        int y = ay + dy[k];
                        if (x >= 0 && y >= 0 && x < m && y < n) {
                            if (board[y][x].equals("1") && visit[y][x] == 0) {
                                q.add(new int[]{y, x});
                                tempWidth++;
                                visit[y][x] = 1;
                            }
                        }
                    }
                }

                maxWidth = Math.max(maxWidth, tempWidth);

            }
        }
        System.out.println(count);
        System.out.println(maxWidth);
    }
}
