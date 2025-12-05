import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, max = 0;
    static Egg[] eggs;

    private static class Egg {

        int s, w;

        public Egg(int S, int W) {
            this.s = S;
            this.w = W;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            eggs[i] = new Egg(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int n, int cnt) {

        if (n == N) {
            return;
        }

        if (eggs[n].s <= 0) { // 또 그냥 return 했었음
            dfs(n + 1, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == n) {
                continue;
            }

            if (eggs[i].s <= 0) {
                continue;
            }

            int tempCnt = cnt;

            eggs[n].s -= eggs[i].w;
            eggs[i].s -= eggs[n].w;

            if (eggs[n].s <= 0) {
                tempCnt++;
            }
            if (eggs[i].s <= 0) {
                tempCnt++;
            }
            if (tempCnt == N) {
                System.out.println(tempCnt);
                System.exit(0);
            }
            max = Math.max(max, tempCnt);
            dfs(n + 1, tempCnt);

            eggs[n].s += eggs[i].w;
            eggs[i].s += eggs[n].w;

        }
    }
}

