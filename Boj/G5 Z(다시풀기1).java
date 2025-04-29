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

        System.out.println(func((int) Math.pow(2, N), c, r));
    }

    static int func(int n, int x, int y) {

        if (n == 0) {
            return 0;
        }

        if (x < n / 2 && y < n / 2) {
            return func(n / 2, x, y);
        } else if (y < n / 2) {
            return (n / 2 * n / 2) + func(n / 2, x - n / 2, y);
        } else if (x < n / 2) {
            return 2 * (n / 2 * n / 2) + func(n / 2, x, y - n / 2);
        } else {
            return 3 * (n / 2 * n / 2) + func(n / 2, x - n / 2, y - n / 2);
        }
    }
}