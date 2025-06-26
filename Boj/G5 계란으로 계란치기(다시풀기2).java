import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] sArr, wArr;
    static int max = 0, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sArr = new int[N + 1];
        wArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");

            sArr[i] = Integer.parseInt(line[0]);
            wArr[i] = Integer.parseInt(line[1]);
        }

        function(1, 0);
        System.out.println(max);
    }

    static void function(int n, int cnt) {

        max = Math.max(max, cnt);

        if (n > N) {
            return;
        }

        if (max == N) {
            return;
        }

        // 이렇게 쓰는게 더 깔끔했네
//        if (sArr[n] <= 0) {
//            function(n + 1, cnt);
//            return;
//        }

        while (sArr[n] <= 0) {
            n++;
//            if (n >= N) { 아.. N까지 허용 범위였지,,
            if (n > N) {
                return;
            }
        }

        for (int i = 1; i <= N; i++) {

            if (i == n) {
                continue;
            }

            if (sArr[i] <= 0) {
                continue;
            }

            sArr[n] -= wArr[i];
            sArr[i] -= wArr[n];
            int temp = cnt;
            if (sArr[n] <= 0) {
                temp++;
            }
            if (sArr[i] <= 0) {
                temp++;
            }
            function(n + 1, temp);
            sArr[n] += wArr[i];
            sArr[i] += wArr[n];
        }

    }
}



