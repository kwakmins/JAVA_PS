import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S2 안녕 - https://www.acmicpc.net/problem/1535
 * 완탐 OR DP - 일정 cost를 넘어가지 않는 선에서 가장 많이 얻을 수 있는 Value
 *
 * N=20이라 완탐 가능. 한단 안한다로 DFS
 * or
 * 배낭 문제 DP 방식으로 풀기
 */
public class Main {

    static int N, max = 0;
    static int[] costs, values;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        costs = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        values = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0, 0);
        System.out.println(max);

//        ## DP 계산법 ##

//        int[] dp = new int[100];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 99; j >= costs[i]; j--) {
//                dp[j] = Math.max(dp[j - costs[i]] + values[i], dp[j]);
//            }
//        }
//
//        System.out.println(dp[99]);
    }

    static void dfs(int cost, int value, int deep) {
        if (deep == N) {
            max = Math.max(max, value);
            return;
        }

        if (cost + costs[deep] < 100) {
            dfs(cost + costs[deep], value + values[deep], deep + 1);
        }
        dfs(cost, value, deep + 1);
    }
}
