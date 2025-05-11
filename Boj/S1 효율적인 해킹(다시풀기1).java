import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static int[] value;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        value = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            // st 쓰냐 안쓰냐에 따라 시초 여부 발생(100,000건 이긴한데 진짜 큰 차이가 안날텐데 문제가 이상함;;)
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            graph[b].add(a);
            graph[a].add(b); // 자식 -> 부모 단방향
        }

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {

            if (max < value[i]) {
                max = value[i];
                list = new ArrayList<>();
                list.add(i);
            } else if (max == value[i]) {
                list.add(i);
            }
        }

//        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);

    }

    static void dfs(int x) {

        visit[x] = true;

        for (int a : graph[x]) {

            if (!visit[a]) {
                value[a]++;
                dfs(a);
            }

        }

    }

//    부모 -> 자식의 value 얻기를 dp 처럼 풀었는데 이는 같은 원소 a를 가진 두 원소 b,c을 가지면, a,a,b,c 이렇게 4개 가져짐
//    static void dfs(int x) {
//
//        if (value[x] != 0) {
//            return;
//        }
//
//        for (int a : graph[x]) {
//
//            if (value[a] == 0) {
//                dfs(a);
//            }
//            value[x] += value[a] + 1;
//        }
//
//    }
}