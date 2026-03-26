import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {

            stack.add(c);

            if (stack.size() >= boom.length()) {
                boolean flag = true;

                for (int i = 0; i < boom.length(); i++) {
                    if (stack.get(stack.size() - 1 - i) != boom.charAt(boom.length() - 1 - i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < boom.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}

