import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * S3 숫자 야구 - https://www.acmicpc.net/problem/2503
 * 완전탐색 + 구현 - 진행중인 숫자 야구 게임에서 정답의 경우의 수 구하기
 *
 * 모든 경우의 수를 조건에 맞는지 확인하며 소거법 사용.
 *
 * @!!! List 를 foreach 하다가 중간에 remove 를 하면 ConcurrentModificationException 발생
 * @!!! 완전탐색을 백트래킹으로만 생각해봄. 너무 복잡하면 모든 경우의 수로 생각하자.
 */
public class Main {

  static List<String> list;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] line = bf.readLine().split(" ");
      checkNum(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
    }

    System.out.println(list.size());
  }

  static void checkNum(String num, int strike, int ball) {
    if (list.isEmpty()) {
      for (int i = 123; i <= 987; i++) {
        String stringI = String.valueOf(i);
        int disSize = Arrays.stream(stringI.split("")).distinct().collect(Collectors.toList())
            .size();
        if (stringI.contains("0") || disSize != 3) {
          continue;
        }
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int j = 0; j < 3; j++) {
          if (num.charAt(j) == stringI.charAt(j)) {
            strikeCnt++;
          } else {
            if (stringI.contains(String.valueOf(num.charAt(j)))) {
              ballCnt++;
            }
          }
        }
        if (strikeCnt == strike && ballCnt == ball) {
          list.add(stringI);
        }
      }
    } else {
      List<String> removeList = new ArrayList<>();
      for (String stringI : list) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int j = 0; j < 3; j++) {
          if (num.charAt(j) == stringI.charAt(j)) {
            strikeCnt++;
          } else {
            if (num.contains(String.valueOf(stringI.charAt(j)))) {
              ballCnt++;
            }
          }
        }
        if (strikeCnt != strike || ballCnt != ball) {
          removeList.add(stringI);
        }
      }
      for (String s : removeList) {
        list.remove(s);
      }
    }
  }
}
