import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int L, C;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    static String[] mo = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        L = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        arr = br.readLine().split(" ");
        Arrays.sort(arr);

        func("", 0, 0, 0, 0);

        System.out.println(sb);
    }

    static void func(String s, int moCnt, int jaCnt, int start, int dep) {

        if (dep == L) {

            if (moCnt >= 1 && jaCnt >= 2) {
                sb.append(s).append("\n");
            }

            return;
        }

        for (int i = start; i < C; i++) {

            if (isMo(arr[i])) {
                func(s + arr[i], moCnt + 1, jaCnt, i + 1, dep + 1);
            } else {
                func(s + arr[i], moCnt, jaCnt + 1, i + 1, dep + 1);
            }

        }

    }

    static boolean isMo(String s) {
        for (String s2 : mo) {
            if (s2.equals(s)) {
                return true;
            }
        }
        return false;
    }
}