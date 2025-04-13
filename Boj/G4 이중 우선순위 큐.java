import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < k; i++) {

                String[] line = br.readLine().split(" ");

                String s = line[0];
                Integer n = Integer.parseInt(line[1]);

                if (s.equals("I")) {
                    maxQ.add(n);
                    minQ.add(n);
                    Integer a = map.getOrDefault(n, 0);
                    map.put(n, a + 1);
                } else {
                    if (n == 1) {
                        while (!maxQ.isEmpty()) {
                            Integer poll = maxQ.poll();
                            Integer temp = map.get(poll);
                            if (temp > 0) {
                                map.put(poll, temp - 1);
                                break;
                            }
                        }
                    } else {
                        while (!minQ.isEmpty()) {
                            Integer poll = minQ.poll();
                            Integer temp = map.get(poll);
                            if (temp > 0) {
                                map.put(poll, temp - 1);
                                break;
                            }
                        }
                    }
                }

            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            boolean b = false;

            for (Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() > 0) {
                    b = true;
                    max = Math.max(max, entry.getKey());
                    min = Math.min(min, entry.getKey());
                }

            }

            sb.append(!b ? "EMPTY" : max + " " + min).append("\n");
        }

        System.out.println(sb);
    }

}

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        while (T-- > 0) {
//
//            int k = Integer.parseInt(br.readLine());
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//
//            for (int i = 0; i < k; i++) {
//
//                String[] line = br.readLine().split(" ");
//
//                String s = line[0];
//                Integer n = Integer.parseInt(line[1]);
//
//                if (s.equals("I")) {
//                    map.put(n, map.getOrDefault(n, 0) + 1);
//                } else {
//                    if (n == -1) {
//                        if (!map.isEmpty()) {
//                            Integer key = map.firstKey();
//                            Integer a = map.getOrDefault(key, 0);
//
//                            if (a == 0 || a == 1) {
//                                map.remove(key);
//                            } else {
//                                map.put(key, a - 1);
//                            }
//                        }
//
//                    } else {
//                        if (!map.isEmpty()) {
//                            Integer key = map.lastKey();
//                            Integer a = map.getOrDefault(key, 0);
//
//                            if (a == 0 || a == 1) {
//                                map.remove(key);
//                            } else {
//                                map.put(key, a - 1);
//                            }
//                        }
//                    }
//
//                }
//            }
//
//            if (map.isEmpty()) {
//                sb.append("EMPTY");
//            } else {
//                sb.append(map.lastKey()).append(" ").append(map.firstKey());
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//    }