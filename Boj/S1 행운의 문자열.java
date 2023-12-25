import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 행운의 문자열 - https://www.acmicpc.net/problem/1342
 * 백트래킹 - 중복 가능한 문자열을 재배치하여, 인접하지 않은 문자열이 나오는 경우의 수 구하기.
 *
 * 알파벳으로 전이랑 같은 문자인지 확인하며 백트래킹.
 * - Array로 DFS를 하면 시간초과 - aaabbb 일 때, 0의 자리 a와 1의 자리 a가 다른 취급이 되기 때문.
 *
 * @!!! 10! DFS는 메모리 부족. 최대한 백트래킹 하자. (파라미터도 적은게 좋음)
 */
public class Main {

    static String s;
    static int[] alpha = new int[27];
    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        n = s.length();
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        dfs(0, -1);

        System.out.println(answer);

    }

    static void dfs(int deep, int prev) {
        if (deep == n) {
            answer++;
            return;
        }

        for (int i = 0; i < 27; i++) {
            if (alpha[i] == 0) {
                continue;
            }

            if (i != prev) {
                alpha[i]--;
                dfs(deep + 1, i);
                alpha[i]++;
            }
        }
    }
}
