import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {

            String[] line = br.readLine().split(" ");
            int type = Integer.parseInt(line[0]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);

            if (type == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }

        }

        System.out.println(sb);

    }

    static int find(int x) {

        if (arr[x] < 0) {
            return x;
        }

        arr[x] = find(arr[x]);

        return arr[x];
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return;
        }

        // y안에 넣는다.
        if (arr[x] >= arr[y]) {

            if (arr[x] == arr[y]) {
                arr[y]--; // 주의) y의 수 추가
            }
            arr[x] = y;
        } else {
            arr[y] = x;
        }


    }

}