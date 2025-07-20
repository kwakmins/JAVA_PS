import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, cal;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        func(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void func(int idx, int value) {

        if (idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] != 0) {
                cal[i]--;
                func(idx + 1, calFunc(value, idx, i));
                cal[i]++;
            }
        }

    }

    static int calFunc(int value, int idx, int type) {

        if (type == 0) {
            return value + arr[idx];
        } else if (type == 1) {
            return value - arr[idx];
        } else if (type == 2) {
            return value * arr[idx];
        } else {
            return value / arr[idx];
        }
    }
}

