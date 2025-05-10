import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = 0;
        int temp = arr[0]; // 부분합

        int min = Integer.MAX_VALUE;

        while (right < N) {

            if (temp >= S) {
                min = Math.min(right - left + 1, min);
                temp -= arr[left];
                left++;
            } else {

                // right = N-1일 때도 left 갱신은 해야하므로
                if (right == N - 1) {
                    break;
                }

                // 증가 후 값 추가
                right++;
                temp += arr[right];
            }

        }

        // 위 방식은 실제 값으로 계산하면서 진행하는 방식.
        // 아래 방식은 아직 게산 안한 다음 right 를 가르키면서 진행하는 방식 (이는 알고리즘을 외워서 사용)
//        while (right <= N) {
//
//            if (temp >= S) {
//                min = Math.min(min, right - left); // right 는 현재 right 의 다음값을 가르키고 있어서
//                temp -= arr[left];
//                left++;
//            } else {
//                temp += arr[right];
//                right++;
//            }
//        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }

}