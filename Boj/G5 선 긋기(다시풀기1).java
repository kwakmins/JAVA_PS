import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static class Line {

        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Line(temp[0], temp[1]));
        }

        list.sort((a, b) -> Integer.compare(a.start, b.start));

        int sum = 0;

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {

            Line line = list.get(i);

            if (line.start > end) {

//                sum += tempSum;
                sum += end - start;
                start = line.start;
                end = line.end;
            } else {
                // 가장 크게 될 때 한번만 해야하므로, 계속 갱신 x
//                tempSum = end - start;
                end = Math.max(end, line.end);
            }

        }

        sum += end - start;
        System.out.println(sum);
    }
}