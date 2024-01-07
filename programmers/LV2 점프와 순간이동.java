/**
 * LV2 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
 * Top-Down DP? - +1 점프는 비용이 1들고, X2 순간이동은 비용이 안들 때, n으로 갈 때 최솟값 구하기
 *
 * 2로 나눠지면 나누고, 안나눠지면 -1 + 비용+1 을 반복한다. (5000 ->0으로 /2 , -1 로 간다고 계산)
 *
 * @!!! Bottom-Up할 때, 이전 고르는 기준이 모호하면 거꾸로 생각해본다
 */
public class Solution {

    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                answer++;
                n -= 1;
            }
        }
        return answer;
    }

}
// DP 시간,메모리 초과 (N=10억 이하) Bottom-UP 방식
//public class Solution {
//
//    int[] dp;
//
//    public int solution(int n) {
//        dp = new int[n + 1];
//        dp[1] = 1;
//        return rec(n);
//    }
//
//    int rec(int x) {
//        if (dp[x] != 0) {
//            return dp[x];
//        }
//
//        if (x % 2 == 0) {
//            return dp[x] = Math.min(rec(x / 2), rec(x - 1) + 1);
//        } else {
//            return dp[x] = rec(x - 1) + 1;
//        }
//    }
//}