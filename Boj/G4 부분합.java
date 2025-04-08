import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        int[] arr = new int[N + 1];
        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            arr[i] = array[i];
        }

        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;

        int tempSum = 0;

        while (left <= right && right <= N) {

            if (tempSum >= S) {
                ans = Math.min(ans, right - left);
                tempSum -= arr[left];
                left++;
            } else {
                tempSum += arr[right];
                right++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }

}