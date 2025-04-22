import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int M = Integer.parseInt(br.readLine());

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        s1.addAll(Arrays.asList(line.split("")));

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("P")) {

                s1.add(command[1]);

            } else if (command[0].equals("L")) {

                if (!s1.isEmpty()) {
                    s2.add(s1.pop());
                }

            } else if (command[0].equals("D")) {

                if (!s2.isEmpty()) {
                    s1.add(s2.pop());
                }

            } else if (command[0].equals("B")) {

                if (!s1.isEmpty()) {
                    s1.pop();
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        while (!s1.isEmpty()) {
            list.add(s1.pop());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        list = new ArrayList<>();
        for (String string : s2) {
            list.add(string);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        System.out.println(sb);
    }
}