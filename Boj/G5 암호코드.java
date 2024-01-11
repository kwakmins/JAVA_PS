import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @G5 암호코드 - https://www.acmicpc.net/problem/2011
 * DP - 영어를 숫자로 암호화 할 때, 나오는 경우의 수 개수 구하기
 *
 * 2자리로 만들어지면 dp[i-1] + dp[i-2] 로 성립하는걸 확인
 * - 2자리라도 0이 있으면 여러 예외가 생김 (현재가 0인경우, 앞의 숫자가 0인경우)
 *
 * @!!! 일관성 문제 때문에 오래걸림 - (i==1일 때 앞에서 로직이 덜 처리되게 하였음 -> 처리할 때 i 검사.)
 * @!!! dp 를 += 하는 발상을 못해봄
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        double[] dp = new double[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            // 일관성 X
//            if (i == 1) {
//                if (Integer.parseInt(s.substring(0, 2)) <= 26) {
//                    dp[1] = 2;
//                } else {
//                    dp[1] = 1;
//                }
//            }
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if (i == 1) {
                        dp[1] = 1;
                    } else {
                        dp[i] = dp[i - 2] % 1000000;
                    }
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                int temp = Integer.parseInt(s.substring(i - 1, i + 1));
                if (temp >= 10 && temp <= 26) {
                    if (i == 1) {
                        dp[1] = 2;
                    } else {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    }
                } else {
                    dp[i] = dp[i - 1] % 1000000;
                }
            }

//            int now = s.charAt(i-1) - '0';
//            if(now >= 1 && now <= 9) {
//                dp[i] += dp[i-1];
//                dp[i] %= 1000000;
//            }
//
//            if(i == 1) continue; //첫번째 글자일 경우
//
//            int prev = str.charAt(i-2) - '0';
//
//            if(prev == 0) continue; //0으로 시작할경우 존재 X
//
//            int value = prev*10+now;
//
//            if(value >= 10 && value <= 26) {
//                dp[i] += dp[i-2];
//                dp[i] %= 1000000;
//            }

        }

        System.out.println((int) (dp[s.length() - 1] % 1000000));
    }
}
