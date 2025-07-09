import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] userArr, cardArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        userArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        M = Integer.parseInt(br.readLine());
        cardArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(userArr);

        StringBuilder sb = new StringBuilder();
        for (int a : cardArr) {
            sb.append(upperBound(a) - lowerBound(a)).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int a) {

        int start = 0;
        int end = N;

        while (start < end) {

            int mid = (end + start) / 2;

            if (userArr[mid] >= a) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int upperBound(int a) {

        int start = 0;
        int end = N;

        while (start < end) {

            int mid = (end + start) / 2;

            if (userArr[mid] <= a) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}

