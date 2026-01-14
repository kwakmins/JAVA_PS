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

        // 높이가 i 이하인 장애물이 몇개인지 구함
        // 이는 나중에 누적합을 계산하기 위해서 (높이가 i일 때 부딛히는 장애물 = 총 장애물(높이H) - 높이가 i일 때 안부딛히는 장애물)
        for (int i = 1; i <= H; i++) {
            down[i] += down[i - 1];
            up[i] += up[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {

            // 총 장애물 - 안부딛히는 장애물 = 부딛히는 장애물
            int sum = down[H] - down[i - 1];
            sum += up[H] - up[H - i];

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

