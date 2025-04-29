import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        func(1, 3, N);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static void func(int start, int target, int n) {

        if (n == 1) {
            sb.append(start).append(" ").append(target).append("\n");
            cnt++;
            return;
        }

        func(start, 6 - start - target, n - 1);
        sb.append(start).append(" ").append(target).append("\n");
        cnt++;
        func(6 - start - target, target, n - 1);

    }
}