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

        int ans = Integer.MAX_VALUE;

        int right = 1;

        for (int left = 0; left < N; left++) {

            while (right < N) {

                if (list.get(right) - list.get(left) >= M) {
                    ans = Math.min(ans, list.get(right) - list.get(left));
                    break;
                }

                right++;

            }

            if (ans == M) {
                break;
            }
        }
        System.out.println(ans);
    }

}