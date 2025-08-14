import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Integer> bMap = new HashMap<>();
    static int[] arrA, arrB;
    static int n, m, T;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < m; i++) {
            dfsB(i, 0);
        }

        for (int i = 0; i < n; i++) {
            dfsA(i, 0);
        }

        System.out.println(result);
    }

    static void dfsA(int idx, int sum) {

        if (idx >= n) {
            return;
        }

        int tempSum = sum + arrA[idx];

        result += bMap.getOrDefault(T - tempSum, 0);
        dfsA(idx + 1, tempSum);

    }

    static void dfsB(int idx, int sum) {

        if (idx >= m) {
            return;
        }

        int tempSum = sum + arrB[idx];

        bMap.put(tempSum, bMap.getOrDefault(tempSum, 0) + 1);
        dfsB(idx + 1, tempSum);

    }
}
