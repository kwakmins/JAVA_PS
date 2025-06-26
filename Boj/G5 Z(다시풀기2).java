import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        System.out.println(recursion(N, r + 1, c + 1));
    }

    static int recursion(int n, int r, int c) {

        if (n == 0) {
            return 0;
        }

        int size = (int) (Math.pow(2, n - 1) * Math.pow(2, n - 1));

        int temp = (int) Math.pow(2, n) / 2;

        if (r <= temp && c <= temp) {
            return recursion(n - 1, r, c);
        } else if (r <= temp && c > temp) {
            return recursion(n - 1, r, c - temp) + size; // c/2 -> c-temp 변경 (왜 이랬지)
        } else if (r > temp && c <= temp) {
            return recursion(n - 1, r - temp, c) + 2 * size;
        } else {
            return recursion(n - 1, r - temp, c - temp) + 3 * size;
        }

    }
}

