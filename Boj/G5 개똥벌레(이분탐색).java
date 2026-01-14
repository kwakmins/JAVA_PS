import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // 석순(바닥에서 올라옴)
    static List<Integer> listA = new ArrayList<>();
    // 종유석(천장에서 내려옴)
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int H = Integer.parseInt(line[1]);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                listA.add(x);
            } else {
                listB.add(x);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int min = Integer.MAX_VALUE;
        int minCnt = 0;

        for (int i = 1; i <= H; i++) {
            // 석순: 길이 >= i
            int hitA = listA.size() - lowerBound(listA, i);

            // 종유석: 길이 >= (H - i + 1)
            int hitB = listB.size() - lowerBound(listB, H - i + 1);

            int hit = hitA + hitB;

            if (hit < min) {
                min = hit;
                minCnt = 1;
            } else if (hit == min) {
                minCnt++;
            }
        }

        System.out.printf("%d %d", min, minCnt);
    }

    static int lowerBound(List<Integer> arr, int x) {
        int start = 0;
        int end = arr.size();

        while (start < end) {

            int mid = (start + end) / 2;

            if (arr.get(mid) >= x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
