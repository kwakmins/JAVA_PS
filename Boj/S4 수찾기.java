import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arrN = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(bf.readLine());
        int[] arrM = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrN);

        for (int n : arrM) {

            System.out.println(binarySearch(n, N, arrN));
        }

    }

    static int binarySearch(int target, int N, int[] arr) {

        int start = 0;
        int end = N - 1;

        while (arr[end] >= arr[start]) {

            int mid = (start + end) / 2;

            if (target > arr[mid]) {

                start = mid + 1;

            } else if (target < arr[mid]) {

                end = mid - 1;

            } else {
                return 1;
            }

        }

        return 0;

    }
}