import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * G4 중복 제거 - https://www.acmicpc.net/problem/13701
 * 비트연산 - 매우 적은 메모리로 많은 데이터 중복 제거
 *
 * 원래 비트로 중복 찾기지만, 자바 Stream.distinct()도 비트로 중복제거 하는듯?
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).distinct()
            .toArray();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]).append(" ");
        }
        System.out.println(sb);
    }
}
