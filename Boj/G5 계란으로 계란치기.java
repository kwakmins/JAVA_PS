import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, maxResult = 0, tempN;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        func(0, 0);

        System.out.println(maxResult);
    }

    static void func(int hand, int count) {

        if (hand == N) {
            maxResult = Math.max(maxResult, count);
            return;
        }

        // 이거 때문에 시간 걸림
        // 그냥 넘어갔을 때를 계산
        if (arr[hand][0] <= 0) {
            func(hand + 1, count);
            return;
        }

        for (int i = 0; i < N; i++) {

            if (i == hand) {
                continue;
            }

            if (arr[i][0] <= 0) {
                continue;
            }

            arr[hand][0] -= arr[i][1];
            arr[i][0] -= arr[hand][1];

            int tempCount = count;

            if (arr[hand][0] <= 0) {
                tempCount++;
            }
            if (arr[i][0] <= 0) {
                tempCount++;
            }

            func(hand + 1, tempCount);

            arr[hand][0] += arr[i][1];
            arr[i][0] += arr[hand][1];
        }
    }
}