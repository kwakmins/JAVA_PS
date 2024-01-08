import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 32프로에서 실패
 * @S1 2-SAT-1 - https://www.acmicpc.net/problem/11277
 * 2-SAT 알고리즘? - 처음보는 알고리즘.
 *
 * 2-SAT 알고리즘을 모르면 풀기 어렵고 굳이 할 필요 없다고 느낌
 */
public class Main {

    static int N, M, ans = 0;
    static int[][] arr;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[M][2];
        value = new int[N + 1];

        for (int i = 0; i < M; i++) {
            line = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int deep) {
        if (deep == M || ans == 1) {
            ans = 1;
            return;
        }

        int temp1 = arr[deep][0];
        int temp2 = arr[deep][1];

        if (value[Math.abs(temp1)] == 0) {
            if (value[Math.abs(temp2)] == 0) {
                if (temp1 * -1 > 0 || temp2 * -1 > 0) {
                    value[Math.abs(temp1)] = temp1 * -1;
                    value[Math.abs(temp2)] = temp2 * -1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                    value[Math.abs(temp2)] = 0;
                }
                if ((temp1 * -1 > 0 || temp2 * 1 > 0) && Math.abs(temp1) != Math.abs(temp2)) {
                    value[Math.abs(temp1)] = temp1 * -1;
                    value[Math.abs(temp2)] = temp2 * 1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                    value[Math.abs(temp2)] = 0;
                }
                if ((temp1 * 1 > 0 || temp2 * -1 > 0) && Math.abs(temp1) != Math.abs(temp2)) {
                    value[Math.abs(temp1)] = temp1 * 1;
                    value[Math.abs(temp2)] = temp2 * -1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                    value[Math.abs(temp2)] = 0;
                }
                if (temp1 * 1 > 0 || temp2 * 1 > 0) {
                    value[Math.abs(temp1)] = temp1 * 1;
                    value[Math.abs(temp2)] = temp2 * 1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                    value[Math.abs(temp2)] = 0;
                }
            } else {

                if (temp2 * value[Math.abs(temp2)] > 0 || temp1 * 1 > 0) {
                    value[Math.abs(temp1)] = temp1 * 1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                }
                if (temp2 * value[Math.abs(temp2)] > 0 || temp1 * -1 > 0) {
                    value[Math.abs(temp1)] = temp1 * -1;
                    dfs(deep + 1);
                    value[Math.abs(temp1)] = 0;
                }
            }
        } else if (value[Math.abs(temp2)] == 0) {

            if (temp1 * value[Math.abs(temp1)] > 0 || temp2 * 1 > 0) {
                value[Math.abs(temp2)] = temp2 * 1;
                dfs(deep + 1);
                value[Math.abs(temp2)] = 0;
            }
            if (temp1 * value[Math.abs(temp1)] > 0 || temp2 * -1 > 0) {
                value[Math.abs(temp2)] = temp2 * -1;
                dfs(deep + 1);
                value[Math.abs(temp2)] = 0;
            }
        } else {
            if (temp1 * value[Math.abs(temp1)] < 0 && temp2 * value[Math.abs(temp2)] < 0) {
                return;
            }
            dfs(deep + 1);
        }
    }
}
