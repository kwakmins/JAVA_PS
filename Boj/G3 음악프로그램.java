import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] inDegree = new int[N + 1];
        List<Integer>[] inDegreeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            inDegreeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 2; j < arr.length; j++) {
                inDegree[arr[j]]++;
                inDegreeList[arr[j - 1]].add(arr[j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                result.add(i);
            }
        }

        while (!q.isEmpty()) {

            int poll = q.poll();

            for (int i : inDegreeList[poll]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                    result.add(i);
                }
            }
        }

        if (result.size() != N) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}

