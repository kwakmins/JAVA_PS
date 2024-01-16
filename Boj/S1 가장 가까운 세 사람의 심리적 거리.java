import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * S1 가장 가까운 세 사람의 심리적 거리 - https://www.acmicpc.net/problem/20529
 * 콤비네이션(백트래킹) - 최대 1000000명 중 3명을 뽑아 MBTI의 차이가 가장 적은 합 구하기
 *
 * 3명이 중복되면 무조건 0이기에, 유형이 16개밖에 없으므로, 최대 32_C_3 이다.
 * map으로 중복 수 확인 및 콤비네이션.
 */
public class Main {

    static List<String> list;
    static String[] arr;
    static Integer min;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            min = Integer.MAX_VALUE;
            list = new ArrayList<>();
            int N = Integer.parseInt(bf.readLine());
            arr = bf.readLine().split(" ");
            Map<String, Integer> map = new HashMap<>();

            boolean flag = false;
            for (String s : arr) {
                Integer temp = map.getOrDefault(s, 0) + 1;
                if (temp == 3) {
                    System.out.println(0);
                    flag = true;
                    break;
                }
                map.put(s, temp);
                list.add(s);
            }
            if (!flag) {
                dfs(0, new ArrayList<>());
                System.out.println(min);
            }
        }
    }

    static void dfs(int deep, List<String> temp) {
        if (deep >= arr.length || temp.size() == 3) {
            if (temp.size() == 3) {
                int cnt =
                    cal(temp.get(0), temp.get(1)) + cal(temp.get(2), temp.get(1)) + cal(temp.get(0),
                        temp.get(2));
                min = Math.min(min, cnt);
            }
            return;
        }
        dfs(deep + 1, temp);
        List<String> temp2 = new ArrayList<>(temp);
        temp2.add(arr[deep]);
        dfs(deep + 1, temp2);
    }

    static int cal(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
