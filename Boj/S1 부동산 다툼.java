import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * S1 부동산 다툼 - https://www.acmicpc.net/problem/20364
 * 구현,트리 - 루트 트리가 1일 때, 왼쪽은 부모트리*2 오른쪽은 부모트리*2+1인 트리에서 방문 가능 여부 확인. 방문X시 위에서 부터 처음 만나는 방문 하지 못하는
 * 값구하기.
 *
 * 부모트리를 구하는 식은 계속 /=2를 해주면 됨. 방문 못할 때 마다 방문 못하는 땅 저장 후 1이 되면 방문 가능 여부 출력.
 * - O(logN)
 */
public class Main {

    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N, Q;
        String[] line = bf.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        Q = Integer.parseInt(line[1]);
        visit = new int[N + 1];

        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(bf.readLine());
            int temp = x;
            int first = 0;

            while (true) {
                if (temp == 1) {
                    if (first == 0) {
                        visit[x] = 1;
                    }
                    System.out.println(first);
                    break;
                }

                if (visit[temp] == 1) {
                    first = temp;
                }

                temp /= 2;
            }
        }
    }
}
