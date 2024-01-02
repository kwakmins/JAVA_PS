import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S2 -2진법 - 10진법 N을 -2진법으로 나타내기.
 * 정수론 - https://www.acmicpc.net/problem/2089
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            System.out.println(0);
        } else {
            while (N != 1) {
                sb.append(Math.abs(N % -2));
                N = (int) Math.ceil((double) N / (-2));
            }
            sb.append(N);
            System.out.println(sb.reverse());
        }
    }
}
