import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * G5 문자열 게임2 - https://www.acmicpc.net/problem/20437
 * 문자열 - 같은 문자가 K개인 최대 + 최소 길이 문자열 길이 구하기
 *
 * 배열 List를 만들어 list[알파벳-'a']에 해당하는 부분의 idx값을 add하여, .size()로 K개 이상일 시 Max,Min을 구한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int min = Integer.MAX_VALUE;
            int max = -1;

            String W = bf.readLine();
            int K = Integer.parseInt(bf.readLine());
            List<Integer>[] list = new List[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < W.length(); i++) {
                list[(int) W.charAt(i) - 'a'].add(i);
            }
            for (int i = 0; i < 26; i++) {
                if (list[i].size() >= K) {
                    int tempMax = 0;
                    int tempMin = Integer.MAX_VALUE;

                    for (int j = 0; j < list[i].size() - K + 1; j++) {
                        tempMax = Math.max(tempMax, list[i].get(j + K - 1) - list[i].get(j) + 1);
                        tempMin = Math.min(tempMin, list[i].get(j + K - 1) - list[i].get(j) + 1);
                    }

                    min = Math.min(tempMin, min);
                    max = Math.max(tempMax, max);
                }
            }
            if (max == -1) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
