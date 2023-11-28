import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * S4 DNA - https://www.acmicpc.net/problem/1969
 * 그리드 - 여러 DNA에서 가장 작게 글자가 다른 합을 가진 DNA 구하기.
 *
 * 모든 DNA에서 한글자씩 가장 많은 것을 구한다.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    String[] dna = new String[N];
    String answerDna = "";
    int answerSum = 0;
    for (int i = 0; i < N; i++) {
      String line2 = bf.readLine();
      dna[i] = line2;
    }

    for (int i = 0; i < M; i++) {
      Map<Character, Integer> map = new HashMap<>();
      int maxValue = 0;
      for (int j = 0; j < N; j++) {
        int value = map.getOrDefault(dna[j].charAt(i), 0) + 1;
        maxValue = Math.max(maxValue, value);
        map.put(dna[j].charAt(i), value);
      }
      if (map.getOrDefault('A', 0) == maxValue) {
        answerDna += "A";
        answerSum += map.getOrDefault('C', 0);
        answerSum += map.getOrDefault('G', 0);
        answerSum += map.getOrDefault('T', 0);
      } else if (map.getOrDefault('C', 0) == maxValue) {
        answerDna += "C";
        answerSum += map.getOrDefault('A', 0);
        answerSum += map.getOrDefault('G', 0);
        answerSum += map.getOrDefault('T', 0);
      } else if (map.getOrDefault('G', 0) == maxValue) {
        answerDna += "G";
        answerSum += map.getOrDefault('C', 0);
        answerSum += map.getOrDefault('A', 0);
        answerSum += map.getOrDefault('T', 0);
      } else if (map.getOrDefault('T', 0) == maxValue) {
        answerDna += "T";
        answerSum += map.getOrDefault('C', 0);
        answerSum += map.getOrDefault('G', 0);
        answerSum += map.getOrDefault('A', 0);
      }

    }

    System.out.println(answerDna);
    System.out.println(answerSum);
  }

}
