import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        int N = new Integer(br.readLine());

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        s1.addAll(Arrays.asList(text.split("")));

        for (int i = 0; i < N; i++) {
            String[] lines = br.readLine().split(" ");

            switch (lines[0]) {
                case "L":
                    if (!s1.isEmpty()) {
                        s2.add(s1.pop());
                    }
                    break;
                case "D":
                    if (!s2.isEmpty()) {
                        s1.add(s2.pop());
                    }
                    break;
                case "B":
                    if (!s1.isEmpty()) {
                        s1.pop();
                    }
                    break;
                case "P":
                    s1.add(lines[1]);
                    break;
            }
        }

        List<String> list = new ArrayList<>(s1);
        List<String> list2 = new ArrayList<>(s2);

        Collections.reverse(list2);
        list.addAll(list2);

        String result = String.join("", list);

        System.out.println(result);
    }

}
