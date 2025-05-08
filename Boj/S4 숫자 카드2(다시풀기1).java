import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int N = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();

        for (int a : arr2) {

            int start = 0;
//            int end = M - 1;  // 이는 10 10 10 = 2-0 이라 2개가 되어버리기 때문에, 찾고 +1이 된 상태로 끝낼 수 있게 M으로 해줌
                                // end의 값이 바뀐다고 답이 바뀌는게 어색한데 upper_bound 특성상 N+1까지 해야 첫 초과 위치를 찾는거임
            int end = M;

            // lower
            // 두 개의 인덱스가 같을 때 반복문이 종료된다.
            while (start < end) {

                int mid = (start + end) / 2;

                if (arr[mid] >= a) {
//                    end = mid - 1;  // mid를 제외하고 왼쪽 탐색 = mid가 하한일수도 있는데?
                    end = mid;
                } else {
//                    start = mid;   // mid를 포함한 오른쪽 탐색 (무한루프)
                    start = mid + 1;
                }
            }

            int temp1 = start;

            start = 0;
//            end = M - 1;
            end = M;

            // upper
            while (start < end) {

                int mid = (start + end) / 2;

                if (arr[mid] > a) {
//                    end = mid - 1;
                    end = mid;
                } else {
//                    start = mid;
                    start = mid + 1;
                }
            }

            int temp2 = start;

            sb.append(temp2 - temp1).append(" ");

        }
        System.out.println(sb);

    }

}