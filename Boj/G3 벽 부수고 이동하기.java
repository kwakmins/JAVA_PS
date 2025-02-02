import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];
        boolean[][] boolVisited = new boolean[N][M];
        // x,y,cnt,bool
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0] = true;

        int result = -1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int x = poll[0];
            int y = poll[1];
            int cnt = poll[2];
            int bool = poll[3];

            if (x == M - 1 && y == N - 1) {
                result = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {

                    if (bool == 1) {
                        if (!boolVisited[ny][nx]) {
                            if (board[ny][nx].equals("0")) {
                                boolVisited[ny][nx] = true;
                                q.add(new int[]{nx, ny, cnt + 1, bool});
                            }
                        }
                    } else {
                        if (!visited[ny][nx]) {
                            if (board[ny][nx].equals("0")) {
                                visited[ny][nx] = true;
                                q.add(new int[]{nx, ny, cnt + 1, bool});
                            } else if (bool == 0) {
                                boolVisited[ny][nx] = true;
                                q.add(new int[]{nx, ny, cnt + 1, 1});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }
}