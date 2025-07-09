import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static List<Integer>[] list;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        arr = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i);
        }

        List<Integer> result = new ArrayList<>();
        int max = 0;
        for (int i = 1; i <= N; i++) {

            int cnt = arr[i];

            if (cnt > max) {
                max = cnt;
                result = new ArrayList<>();
                result.add(i);
            } else if (cnt == max) {
                result.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);

    }

    static void dfs(int a) {

        visit[a] = true;

        for (int i : list[a]) {
            if (!visit[i]) {
                arr[i]++;
                dfs(i);
            }
        }


    }

//
//    static int dfs(int a) {
//
//        if (dp[a] != 0) {
//            return dp[a];
//        }
//
//        for (int i : list[a]) {
//            dp[a] += dfs(i);
//        }
//        dp[a] += 1;
//        return dp[a];
//    }
}

