import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * G5 다각형의 면적 - https://www.acmicpc.net/problem/2166
 * 기하학, 신발끈 공식 - 다각형의 꼭짓점의 좌표로 면적 구하기(신발끈 공식임)
 *
 * 신발끈 공식 = 0.5 * (절대값)|(오른쪽 곱 대각선([i][0]*[i+1][1]) - 왼쪽 곱 대각선)|
 * - 마지막은 처음이랑 연결.
 *
 * @!!! 반올림 String.format(" % .1f ") OR Math.around(x * 100)/100.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] board = new long[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        board[N] = board[0];

        long temp1 = 0, temp2 = 0;
        for (int i = 0; i < N; i++) {
            temp1 += board[i][0] * board[i + 1][1];
            temp2 += board[i][1] * board[i + 1][0];
        }
        System.out.println(String.format("%.1f", Math.abs(temp1 - temp2) * 0.5));
    }
}
