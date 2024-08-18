import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G5 Z - https://www.acmicpc.net/problem/1074
 * 재귀
 *
 * @!!! 재귀에 대한 실력이 부족 - 귀납적 사고 부족
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        System.out.println(z(N, r, c));
    }

    static int z(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int temp = (int) Math.pow(2, n - 1);
        if (r < temp && c < temp) {
            return z(n - 1, r, c);
        } else if (r < temp && c >= temp) {
            return temp * temp + z(n - 1, r, c - temp);
        } else if (r >= temp && c < temp) {
            return temp * temp * 2 + z(n - 1, r - temp, c);
        } else {
            return temp * temp * 3 + z(n - 1, r - temp, c - temp);
        }
    }
}
