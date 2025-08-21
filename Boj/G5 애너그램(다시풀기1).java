import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static Set<String> set;
    static boolean[] visit;
    static String[] tempWord;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            set = new TreeSet<>();
            visit = new boolean[word.length()];
            tempWord = word.split("");
            dfs(0, "");
            set.forEach(System.out::println);
        }

    }

    static void dfs(int depth, String s) {

        if (depth == tempWord.length) {
            set.add(s);
            return;
        }

        boolean[] tempAlphaVisit = new boolean[26];

        for (int i = 0; i < tempWord.length; i++) {

            if (!visit[i] && !tempAlphaVisit[tempWord[i].charAt(0) - 'a']) {

                tempAlphaVisit[tempWord[i].charAt(0) - 'a'] = true;
                visit[i] = true;
                dfs(depth + 1, s + tempWord[i]);
                visit[i] = false;
            }
        }
    }
}

