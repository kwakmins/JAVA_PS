import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE; // 항상 고를 수 있다 하니까

        // 투포
        int left = 0;
        int right = 1;

        while (right < N) {

            int temp = arr[right] - arr[left];

            if (temp == M) {
                min = temp;
                break;
            }

            if (temp > M) {
                min = Math.min(min, temp);
                left++;
            } else {
                right++;
            }

        }

        System.out.println(min);

        // lower_bound
//        for (int i = 0; i < N - 1; i++) {
//
//            int start = i;
//            int end = N;
//
//            while (start < end) {
//
//                int mid = (start + end) / 2;
//
//                if (arr[mid] - arr[i] == M) {
//                    min = M;
//                    break;
//                } else if (arr[mid] - arr[i] > M) {
//                    end = mid;
//
//                    min = Math.min(min, arr[mid] - arr[i]);
//
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }
//
//        System.out.println(min);

    }

}