import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            boolean isError = false;
            String[] function = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            String readLine = br.readLine();
            String[] arr = readLine.substring(1, readLine.length() - 1).split(",");

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            // n보다 크거나 작은 수도 올 수 있음;
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(arr[i]));
            }

            boolean isReverse = false;

            for (String s : function) {

                if (s.equals("R")) {
                    isReverse = !isReverse;
                }
                // D
                else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            ArrayList<Integer> list = new ArrayList<>(deque);
            // 실제로 뒤집어지도록 보여야하므로
            if (isReverse) {
                Collections.reverse(list);
            }

            for (int i = 0; i < list.size(); i++) {

                sb.append(list.get(i));

                if (i == list.size() - 1) {
                    continue;
                }
                sb.append(",");
            }

            sb.append("]");
            System.out.println(sb);

        }
    }
}