import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @G5 조 짜기 - https://www.acmicpc.net/problem/2229
 * DP - 연속적인 부분함수를 만들 때, 모든 부분함수의 최대 최소의 차이값의 합이 가장 큰 값 구하기.
 *
 * dp로 i를 포함할 때 최대,최소 값을 구함 -> i에서 for문으로 -1씩 위치를 넣어 그 중 가장 큰 값 구하기
 *
 * @!!! DP라서 for문을 아예 안쓴다는 생각으로 풀려고 했음 (최대 최소값을 따로 3중 배열로 저장 등..). -> DP도 적절한 for문 필요
 * @!!! 연속적인 부분함수는 DP로 i에서 다시 역순 for문 자주 돌리는 듯 함.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = i; j >= 0; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (j == 0) {
                    dp[i] = Math.max(dp[i], max - min);
                } else {
                    dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
                }
            }
        }
        System.out.println(dp[N - 1]);
    }
}
