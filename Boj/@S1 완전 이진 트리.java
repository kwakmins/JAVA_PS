import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @S1 완전 이진 트리 - https://www.acmicpc.net/problem/9934
 * 재귀 - 트리 탐색 역순으로
 * mid 부터 탐색하며 재귀를 그리면서 탐색하면됨
 * .
 * @!!! 배열을 순서대로만 접근하려고 함 (mid 부터 시작한다는 생각을 못함)
 * @!!! 배열은 0부터 시작, 하지만 문제는 1부터 시작할 때 배열에 접근할 때만 -1을 해주자
 * - 변수 저장부터 -1로 하면 헷갈림..
 */
public class Main {

    static int k;
    static int[] board;
    static List[] tree = new ArrayList[11];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(bf.readLine());
        board = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= k; i++) {
            tree[i] = new ArrayList<>();
        }

        search(1, ((int) Math.pow(2, k)) - 1, 1);

        for (int i = 1; i <= k; i++) {
            for (Object o : tree[i]) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }

    static void search(int start, int end, int depth) {
        int mid = (start + end) / 2;
        tree[depth].add(board[mid - 1]);

        if (depth == k) {
            return;
        }

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}
