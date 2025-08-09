import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int H = Integer.parseInt(line[1]);

        int[] up = new int[H + 1];
        int[] down = new int[H + 1];
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                up[h]++; // 위치 저장
            } else {
                down[h]++;
            }
        }

        // 누적합 = 높이가 i 이하일 때 장애물 총 수
        for (int i = 1; i <= H; i++) {
            up[i] += up[i - 1];
            down[i] += down[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int sum = down[H] - down[i - 1] + up[H] - up[H - i]; // 총 장애물 - 안부딛히는 장애물 = 부딛히는 장애물

            if (min == sum) {
                cnt++;
            } else if (sum < min) {
                min = sum;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);
    }
}

