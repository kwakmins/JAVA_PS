import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        int result = recursion(r, c, N);

        System.out.println(result);
    }

    static int recursion(int r, int c, int n) {

        if (n == 0) {
            return 0;
        }

        int powN = (int) Math.pow(2, n - 1);

        if (r < powN && c < powN) {
            return recursion(r, c, n - 1);
        } else if (r < powN && c >= powN) {
            return powN * powN + recursion(r, c - powN, n - 1);
        } else if (r >= powN && c < powN) {
            return 2 * (powN * powN) + recursion(r - powN, c, n - 1);
        } else {
            return 3 * (powN * powN) + recursion(r - powN, c - powN, n - 1);
        }
    }
}