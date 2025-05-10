import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            while (k-- > 0) {

                String[] line = br.readLine().split(" ");
                int n = Integer.parseInt(line[1]);

                // 삽입
                if (line[0].equals("I")) {

                    pq.add(n);
                    reversePq.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                // 삭제
                else {

                    // 최솟값
                    if (n == -1) {

                        while (!pq.isEmpty()) {

                            Integer poll = pq.poll();

                            if (map.get(poll) > 0) {
                                map.put(poll, map.get(poll) - 1); // 이미 없는 값을 poll 하면 다시 poll 하도록. 있는 값이면 -1로 없애기
                                break;
                            }
                        }

                    }
                    // 최대값
                    else {
                        while (!reversePq.isEmpty()) {

                            Integer poll = reversePq.poll();

                            if (map.get(poll) > 0) {
                                map.put(poll, map.get(poll) - 1);
                                break;
                            }
                        }
                    }

                }

                // 허수값 제거
                while (!pq.isEmpty()) {

                    Integer peek = pq.peek();

                    if (map.get(peek) > 0) {
                        break;
                    }
                    pq.poll();
                }

                while (!reversePq.isEmpty()) {

                    Integer peek = reversePq.peek();

                    if (map.get(peek) > 0) {
                        break;
                    }
                    reversePq.poll();
                }

            }
            if (pq.isEmpty() || reversePq.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(reversePq.poll() + " " + pq.poll());
            }


        }
    }

}