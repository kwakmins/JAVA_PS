import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int result = 0;

        for (int[] arr : list) {
            // 새로운
            if (arr[0] > end) {

                result += end - start;
                start = arr[0];
                end = arr[1];
            } else if (end < arr[1]) {
                end = arr[1];
            }
        }

        System.out.println(result + end - start);
    }
}

