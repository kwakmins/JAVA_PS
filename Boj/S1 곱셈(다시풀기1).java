import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int A, B, C;
//    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        A = Integer.parseInt(line[0]);
        B = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);
        A %= C;

        System.out.println(func(B));
    }

    static long func(int n) {

        if (n == 1) {
            return A;
        }

        if (n % 2 == 1) {

            long x = func(n / 2);
//            long y = func(n / 2 + 1); // 중복계산 = dp에서나 쓸 수 있음
//            long y = x * A % C;  // x*A 가 overflow 될 수 있음
//            long y = x % C * A % C; // 모듈러 연산 깨짐

            return (x * x % C) * A % C; // 모듈러 MOD((x*x)*A) = MOD( MOD(x*x) * MOD(A) )
        } else {

            long x = func(n / 2);
            return (x * x % C) % C;
        }

    }
}

