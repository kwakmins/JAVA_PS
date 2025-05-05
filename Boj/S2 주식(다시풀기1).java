import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            br.readLine();
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i : line) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                pq.add(i);
            }

            int result =0;
//            long result = 0;

            for (int i : line) {

                int peek;

                while (true) {
                    peek = pq.peek();

                    if (map.get(peek) == 0) {
                        pq.poll();
                        continue;
                    }
                    break;
                }
                result += peek - i;
                map.put(i, map.getOrDefault(i, 1) - 1);
            }

            System.out.println(result);
        }


    }
}