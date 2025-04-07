import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        List<Integer> list = new ArrayList<>();

        int tempN = N;
        while (tempN-- > 0) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {

            int start = i;
            int end = N;

            while (start < end) {

                int mid = (start + end) / 2;

                if (list.get(mid) - list.get(i) < M) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (end == N) {
                continue;
            }

            answer = Math.min(answer, list.get(end) - list.get(i));

            if (answer == M) {
                break;
            }
        }

        System.out.println(answer);

    }

}