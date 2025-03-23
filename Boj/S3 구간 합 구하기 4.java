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

        int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] d = new int[N];
        d[0] = board[0];
        for (int i = 1; i < N; i++) {
            d[i] = d[i - 1] + board[i];
        }

        for (int z = 0; z < M; z++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int i = temp[0] - 1;
            int j = temp[1] - 1;

            // 이는 이는 d[j] - d[i-1] 과 같지만 1-indexed 를 쓰면 1일 때 [-1]로 접근되기 때문에.
            System.out.println(d[j] - d[i] + board[i]);

            // if else 로 처리도 가능
//            int i = temp[0] - 2;
//            int j = temp[1] - 1;
//
//            if (i < 0) {
//                System.out.println(d[j]);
//            } else {
//                System.out.println(d[j] - d[i]);
//            }
        }
    }
}