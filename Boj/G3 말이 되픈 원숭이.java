import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int w = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);

        String[][] board = new String[h][2];
        for (int i = 0; i < h; i++) {
            board[i] = br.readLine().split(" ");
        }

        int result = -1;

        Queue<int[]> q = new LinkedList<>();

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int[] acx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] acy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

        boolean[][][] visited = new boolean[h][w][k + 1];

        // x,y,cnt,action
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {

            int[] poll = q.poll();
            int x = poll[0], y = poll[1], cnt = poll[2], action = poll[3];

            if (x == w - 1 && y == h - 1) {
                result = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (!visited[ny][nx][action] && board[ny][nx].equals("0")) {
                        visited[ny][nx][action] = true;
                        q.add(new int[]{nx, ny, cnt + 1, action});
                    }
                }
            }
            if (action < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + acx[i], ny = y + acy[i];

                    if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                        if (!visited[ny][nx][action + 1] && board[ny][nx].equals("0")) {
                            visited[ny][nx][action + 1] = true;
                            q.add(new int[]{nx, ny, cnt + 1, action + 1});
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }
}