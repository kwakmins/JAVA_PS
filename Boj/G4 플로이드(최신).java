import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        int maxValue = 987654321;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = maxValue;
            }
        }

        for (int i = 0; i < m; i++) {

            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int z = 1; z <= n; z++) {

                    arr[j][z] = Math.min(arr[j][z], arr[j][i] + arr[i][z]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == maxValue) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}