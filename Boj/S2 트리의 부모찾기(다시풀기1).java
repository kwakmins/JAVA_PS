import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] result;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        result = new int[N + 1];
        visit = new boolean[N + 1]; // 없어도 되고 result로 확인하면 될듯

        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            String[] line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int x) {

        visit[x] = true;

        for (int a : list[x]) {

            if (!visit[a]) {
                result[a] = x;
                dfs(a);
            }
        }

    }
}