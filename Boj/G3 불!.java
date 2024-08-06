import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * G3 불! - https://www.acmicpc.net/problem/4179
 * BFS - 둘이 동시의 BFS
 * 풀이 : 불과 사람 따로 BFS를 한 뒤 불보다 빠르고, 탈출할 수 있는 수 중 가장 빠른 길 선택
 * - 더 효율적인 풀이 : 불 먼저 BFS 한 뒤, 사람의 BFS 도중 불보다 빠른 곳만 탐색 + 도중에 탈출 조건 만족하면 끝내기
 *
 * @@@ 테케가 최솟값인 경우를 항상 먼저 생각하자
 * @@@ 크기 비교를 하는 곳에서 초기화는 신중히 하자
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        String[][] board = new String[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
        }

        int[][] visitJ = new int[R][C];
        int[][] visitF = new int[R][C];
        Queue<int[]> qj = new LinkedList<>();
        Queue<int[]> qf = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j].equals("J")) {
                    visitJ[i][j] = 1;
                    qj.add(new int[]{i, j});
                }
                // 밑에 조건 때문에 0으로 초기화 X or 조건문 추가
                else {
                    visitJ[i][j] = 10000001;
                }
                if (board[i][j].equals("F")) {
                    visitF[i][j] = 1;
                    qf.add(new int[]{i, j});
                } else {
                    visitF[i][j] = 10000001;
                }
            }
        }

        int dx[] = new int[]{1, -1, 0, 0};
        int dy[] = new int[]{0, 0, 1, -1};

        //불
        while (!qf.isEmpty()) {
            int[] poll = qf.poll();
            int qx = poll[1];
            int qy = poll[0];

            for (int i = 0; i < 4; i++) {
                int x = qx + dx[i];
                int y = qy + dy[i];

                if (x >= 0 && y >= 0 && x < C && y < R) {
                    if (visitF[y][x] == 10000001 && board[y][x].equals(".")) {
                        visitF[y][x] = visitF[qy][qx] + 1;
                        qf.add(new int[]{y, x});
                    }
                }
            }
        }

        // 지훈
        while (!qj.isEmpty()) {
            int[] poll = qj.poll();
            int qx = poll[1];
            int qy = poll[0];

            for (int i = 0; i < 4; i++) {
                int x = qx + dx[i];
                int y = qy + dy[i];
//
//                if (x < 0 || y < 0 || x >= C || y >= R) {
//                    // 가장자리에 도달한 경우
//                    System.out.println(visitJ[qy][qx]);
//                    return;
//                }

                if (x >= 0 && y >= 0 && x < C && y < R) {
                    if (visitJ[y][x] == 10000001 && board[y][x].equals(".")) {
                        visitJ[y][x] = visitJ[qy][qx] + 1;
                        qj.add(new int[]{y, x});
                    }
                }
            }
        }

//        System.out.println("IMPOSSIBLE");

        // BFS는 어차피 visit에 제일 낮은 숫자가 들어가니까 지훈이 불보다 낮은 숫자이면서 가장자리에 있는 숫자 중, 가장 낮은수로 계산
        // 이 때 최소 수를 생각안함 (visitF[i][j]가 0이면서(F가 없을 때) 탈출할 때도 불이 더 빨리 도착인 로직이였음)
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i != 0 && j != 0 && j != C - 1 && i != R - 1) {
                    continue;
                }
                if (visitJ[i][j] == 0) {
                    continue;
                }

                if (visitJ[i][j] < visitF[i][j]) {
                    min = Math.min(visitJ[i][j], min);
                }
                // 0으로 초기화했을 때
//                if (visitF[i][j] == 0 || visitJ[i][j] < visitF[i][j]) {
//                    min = Math.min(visitJ[i][j], min);
//                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(min);
        }

    }
}
