import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M, result = Integer.MAX_VALUE;
    static List<int[]> homeList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static boolean[] existIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                String s = line[j];
                if (s.equals("1")) {
                    homeList.add(new int[]{i, j});
                } else if (s.equals("2")) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        existIdx = new boolean[chickenList.size()];

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int idx, int cnt) {

        if (cnt == M) {
            int tempSum = 0;

            for (int i = 0; i < homeList.size(); i++) {

                int min = Integer.MAX_VALUE;

                for (int j = 0; j < chickenList.size(); j++) {
                    if (!existIdx[j]) {
                        continue;
                    }

                    int[] chickenArr = chickenList.get(j);
                    int[] homeArr = homeList.get(i);

                    min = Math.min(min, Math.abs(chickenArr[0] - homeArr[0]) + Math.abs(chickenArr[1] - homeArr[1]));
                }
                tempSum += min;
            }

            result = Math.min(tempSum, result);
            return;
        }

        for (int i = idx; i < chickenList.size(); i++) {
            existIdx[i] = true;
            dfs(i + 1, cnt + 1);
            existIdx[i] = false;
        }

    }
}

