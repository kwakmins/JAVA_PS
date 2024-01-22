import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @G5 Fly me to the Alpha Centauri - https://www.acmicpc.net/problem/1011
 * 수학 - x에서 y로 이동할 때 전 이동의 -1,0,+1 만큼만 이동이 가능하고, y이동 직전 +1로만 가야할 때 최소 이동 회수 구하기
 *
 * 표로 정리하면 공식이 생김. 거리는 완전제곱수 기준으로 완전제곱수 + 제곱근보다 큰 수 작은 수 마다 회수 바뀜.
 * .
 * @!!! 수학 식 모르겠으면 표로 만들어 정리 후 공식 구하자 (그래도 힘들듯?)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            int dis = y - x;
            int n = (int) Math.sqrt(dis);

            if (dis == n * n) {
                System.out.println(n * 2 - 1);
            } else if (dis > n * n + n) {
                System.out.println(n * 2 + 1);
            } else if (dis <= n * n + n) {
                System.out.println(n * 2);
            }
        }
    }
}
