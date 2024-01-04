import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * S2 과자 나눠주기 - https://www.acmicpc.net/problem/16401
 * 이분탐색 - M명에게 공평하게 과자를 나눠줄 때 가장 크게 줄 수 있는 수 구하기
 *
 * 1부터 과자의 가장 긴 수로 이분탐색 (M개이상이 나오면 저장후 더 높게 탐색)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M, N;
        String[] line = bf.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        int[] boards = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        Arrays.sort(boards);
        int start = 1;
        int end = boards[N - 1];
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int temp = 0;
            for (int i : boards) {
                temp += i / mid;
            }

            if (temp >= M) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
