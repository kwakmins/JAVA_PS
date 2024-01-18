import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * G5 선수과목
 * DP,구현 - 특정 과목을 들을려면 다른 특정 과목을 들어야 하는 경우가 있을 때, 모든 과목의 최소 몇학기 걸리는지 구하기.
 *
 * 순서대로 과목에 연관된 과목들의 최소 학기 +1 한 값 중 가장 큰 값. 연관된 과목이 없으면 최소 학기 = 1
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        List<Integer>[] list = new List[N + 1];
        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            list[B].add(A);
        }

        for (int i = 1; i <= N; i++) {
            if (list[i].isEmpty()) {
                value[i] = 1;
            } else {
                for (int A : list[i]) {
                    value[i] = Math.max(value[A] + 1, value[i]);
                }
            }
            System.out.print(value[i] + " ");
        }
    }
}
