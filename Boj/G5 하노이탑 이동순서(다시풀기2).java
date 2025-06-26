import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);

        System.out.println(hanoi(N, 1, 3));
        System.out.println(sb);
    }

    static int hanoi(int n, int from, int to) {

        if (n == 0) {
            return 0;
        }

        int mid = 6 - from - to;

        int value = 0;

        value += hanoi(n - 1, from, mid);
        value += 1;
        sb.append(from).append(" ").append(to).append('\n');
        value += hanoi(n - 1, mid, to);
        return value;

    }
}

