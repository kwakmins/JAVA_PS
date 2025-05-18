import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] prevList = new List[N + 1];
        // 선행될 수
        int[] arr = new int[N + 1];
        int[] timeArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prevList[i] = new ArrayList<>();
        }

        List<Integer> taskList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            String[] line = br.readLine().split(" ");
            int time = Integer.parseInt(line[0]);
            timeArr[i] = time;
            int prevSize = Integer.parseInt(line[1]);

            if (prevSize == 0) {
                taskList.add(i);
            }
            for (int j = 0; j < prevSize; j++) {
                int prevTask = Integer.parseInt(line[j + 2]);
                arr[i]++;
//                prevList[i].add(prevTask);
                prevList[prevTask].add(i);
            }
        }

        int resultSum = 0;
        int cnt = 0;
        while (true) {

            if (cnt == N) {
                break;
            }
            resultSum++;

            List<Integer> tempList = new ArrayList<>(taskList);
            for (int task : tempList) {
                timeArr[task]--;
                if (timeArr[task] == 0) {
                    cnt++;
                    for (int prev : prevList[task]) {
                        arr[prev]--;
                        if (arr[prev] == 0) {
                            taskList.add(prev);
                        }
                    }
                }
            }
        }
        System.out.println(resultSum);


    }
}

