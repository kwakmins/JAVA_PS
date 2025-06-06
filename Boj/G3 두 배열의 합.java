import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] arrA, arrB;
    static int N, M;
    static List<Long> listA = new ArrayList<>();
    static List<Long> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            dfsA(i, 0);
        }
        for (int i = 0; i < M; i++) {
            dfsB(i, 0);
        }
        Collections.sort(listA);
        Collections.sort(listB);

        long result = 0;

        for (long aValue : listA) {

            long bValue = T - aValue;

            result += upperBound(bValue) - lowerBound(bValue);
        }

        System.out.println(result);
    }

    static int lowerBound(long target) {

        int start = 0;
        int end = listB.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (listB.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int upperBound(long target) {

        int start = 0;
        int end = listB.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (listB.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static void dfsA(int index, long sum) {
        sum += arrA[index];
        listA.add(sum);

        if (index + 1 == N) {
            return;
        }
        dfsA(index + 1, sum);
    }

    static void dfsB(int index, long sum) {
        sum += arrB[index];
        listB.add(sum);

        if (index + 1 == M) {
            return;
        }
        dfsB(index + 1, sum);
    }
}
