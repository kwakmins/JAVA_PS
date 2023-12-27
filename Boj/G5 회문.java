import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G5 회문 - https://www.acmicpc.net/problem/17609
 * 구현,문자열 - 회문, 하나만 빼면 회문이 되는 문자열, 그것도 안되는 문자열 이렇게 구분을 하는 문제.
 *
 * 회문이 아닐 때, 앞 포인트를 뺀후 회문 확인 + 뒤 포인트를 뺀 후 회문 확인 으로 판별
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            String s = bf.readLine();
            int cnt = 0;
            int i = 0, j = s.length() - 1;
            while (j > i) {
                if (s.charAt(i) != s.charAt(j)) {

                    if (s.charAt(i + 1) == s.charAt(j)) {
                        int i1 = i + 2, j1 = j - 1, cnt1 = 1;
                        while (j1 > i1) {
                            if (s.charAt(i1) != s.charAt(j1)) {
                                cnt1++;
                                break;
                            }
                            i1++;
                            j1--;
                        }
                        if (cnt1 == 1) {
                            cnt = 1;
                            break;
                        }
                    }
                    if (s.charAt(i) == s.charAt(j - 1)) {
                        int i1 = i + 1, j1 = j - 2, cnt1 = 1;
                        while (j1 > i1) {
                            if (s.charAt(i1) != s.charAt(j1)) {
                                cnt1++;
                                break;
                            }
                            i1++;
                            j1--;
                        }
                        if (cnt1 == 1) {
                            cnt = 1;
                            break;
                        }
                    }
                    cnt = 2;
                    break;
                }
                i++;
                j--;
            }
            System.out.println(cnt);
        }
    }
}
