import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] d2 = new int[N + 1];

        d2[1] = 1;

        for (int i = 2; i <= N; i++) {

            d[i] = d[i - 1] + 1;
            d2[i] = i - 1;

            if (i % 2 == 0) {
                int temp = d[i / 2] + 1;

                if (temp < d[i]) {
                    d[i] = temp;
                    d2[i] = i / 2;
                }
            }

            if (i % 3 == 0) {

                int temp = d[i / 3] + 1;

                if (temp < d[i]) {
                    d[i] = temp;
                    d2[i] = i / 3;
                }
            }
        }

        System.out.println(d[N]);

        StringBuilder sb = new StringBuilder();

//        sb.append(N).append(" ");
//        if (N == 1) {
//            System.out.println(sb);
//            return;
//        }
        while (true) {
//            sb.append(d2[N]).append(" ");
            sb.append(N).append(" ");
            if (N == 1) {
                break;
            }
            N = d2[N];
        }
        System.out.println(sb);
    }

    // 객체에 stack 등 참조가 선언되어있으면 매우 복잡하고, 복사하는데 시간 + 공간이 부족하니까 지양하자
//    static private class Obj {
//
//        public int value;
//        public Stack<Integer> s;
//
//        public Obj(int value, Stack<Integer> s) {
//            this.value = value;
//            Stack<Integer> stack = new Stack<>();
//            stack.addAll(s);
//            this.s = stack;
//        }
//
//        public void print() {
//            System.out.println(value);
//            StringBuilder sb = new StringBuilder();
//            for (Integer i : s) {
//                sb.append(i).append(" ");
//            }
//            System.out.println(sb);
//        }
//    }
}