import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int resultCnt = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().split(" ")[0]);

        sb = new StringBuilder();

        fun(1, 3, n);
        System.out.println(resultCnt);
        System.out.println(sb);
    }

    static void fun(int a, int b, int n) {
        resultCnt++;

        if (n == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }

        fun(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        fun(6 - a - b, b, n - 1);
    }

}