import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int k = 0;
    static String[] line;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            line = br.readLine().split(" ");

            k = Integer.parseInt(line[0]);
            if (k == 0) {
                break;
            }

            func("", 0, 0);
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static void func(String s, int start, int dep) {

        if (dep == 6) {
            sb.append(s.trim()).append("\n");
            return;
        }

        for (int i = start; i < k; i++) {

            func(s + line[i + 1] + " ", i + 1, dep + 1);
        }
    }
}