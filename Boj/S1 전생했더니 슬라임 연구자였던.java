import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @S1 전생했더니 슬라임 연구자였던 건에 대하여 - https://www.acmicpc.net/problem/14715
 * 정수론,완전 이진 트리 - 주어진 수가 2개로 쪼갤 수 있을 때, 2개로 분열하는데 이를 반복해서 리프노드를 구하는 방식중 가장 작은 높이 구하기
 *
 * 어떻게 쪼개든 리프노드의 값들은 같음 -> 완전 이진 트리의 높이 공식 = (ceil(Log(리프 노드 개수))
 * @!!! int h = (int) Math.ceil(Math.log(N) / Math.log(2)) // log2(N)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        int cnt = 1;

        while (true) {
            boolean b = false;
            for (int i = 2; i <= Math.sqrt(K); i++) {
                if (K % i == 0) {
                    b = true;
                    K /= i;
                    cnt++;
                    break;
                }
            }
            if (!b) {
                break;
            }
        }
        System.out.println((int) Math.ceil(Math.log10(cnt) / Math.log10(2)));
    }
}

// 시간초과 (모든 경우의 수 계산 (0.5초))
//public class Main {
//
//    static int answer = Integer.MAX_VALUE;
//    static int temp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int K = Integer.parseInt(bf.readLine());
//        for (int i = 2; i <= Math.sqrt(K) + 1; i++) {
//            if (K % i == 0) {
//                temp = 0;
//                div(i, 1);
//                div(K / i, 1);
//                answer = Math.min(temp, answer);
//            }
//        }
//        if (answer == Integer.MAX_VALUE) {
//            System.out.println(0);
//        } else {
//            System.out.println(answer);
//        }
//    }
//
//    static void div(int k, int deep) {
//
//        temp = Math.max(temp, deep);
//
//        for (int i = 2; i <= Math.sqrt(k) + 1; i++) {
//            if (k % i == 0) {
//                div(i, deep + 1);
//                div(k / i, deep + 1);
//            }
//        }
//    }
//}
