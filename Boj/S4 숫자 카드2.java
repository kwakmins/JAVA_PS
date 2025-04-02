import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arrN = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrN);

        int M = Integer.parseInt(bf.readLine());
        int[] arrM = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i : arrM) {
            sb.append(upperBound(N, arrN, i) - lowerBound(N, arrN, i) + " ");
        }
        System.out.println(sb);

    }

    static int upperBound(int N, int[] arrN, int target) {

        int start = 0;
        int end = N;

        while (start < end) {

            int mid = (start + end) / 2;

            if (target >= arrN[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;

    }

    static int lowerBound(int N, int[] arrN, int target) {

        int start = 0;
        int end = N;

        while (start < end) {

            int mid = (start + end) / 2;

            if (target > arrN[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;

    }

}