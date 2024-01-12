import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * S1 경비원 - https://www.acmicpc.net/problem/2564
 * 구현 - 블록의 가장자리만 이동이 가능할 때, X지점에서 다른 지점으로 이동하는 최소 총 합 구하기.
 *
 * 방식 1 - 일일히 위치 따라 계산식 구하기.
 * 방식 2 - 블록을 일자로 펼쳐서 계산. (간단)
 *
 * @!!! 방식 1은 아닌 것 같아서 다른 방식 생각하다가 시간 너무 많이 씀.. 그냥 풀 수 있으면 풀자.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int cnt = Integer.parseInt(bf.readLine());
        int[] arr = new int[cnt + 1];
        for (int i = 0; i <= cnt; i++) {
            line = bf.readLine().split(" ");
            int x = Integer.parseInt(line[1]);
            if (line[0].equals("1")) {
                arr[i] = x;
            } else if (line[0].equals("4")) {
                arr[i] = N + x;
            } else if (line[0].equals("2")) {
                arr[i] = 2 * N + M - x;
            } else if (line[0].equals("3")) {
                arr[i] = 2 * N + M * 2 - x;
            }
        }

        int answer = 0;
        for (int i = 0; i < cnt; i++) {
            int temp = Math.abs(arr[i] - arr[cnt]);
            answer += Math.min(temp, N * 2 + M * 2 - temp);
        }
        System.out.println(answer);
    }
}
