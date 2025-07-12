import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int N;
    //    static boolean[] visit;
    static StringBuilder sb;
    static Set<String> set;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (String s : arr) {
            sb = new StringBuilder();
            set = new TreeSet<>();
            alpha = new int[26];

            for (char ss : s.toCharArray()) {
                alpha[ss - 'a']++;
            }

            func("", 0, s.length());

            for (String result : set) {
                System.out.println(result);
            }
        }
    }

    public static void func(String s, int cnt, int size) {

        if (cnt == size) {
            set.add(s);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                func(s + (char) (i + 'a'), cnt + 1, size);
                alpha[i]++;
            }
        }

    }
}

