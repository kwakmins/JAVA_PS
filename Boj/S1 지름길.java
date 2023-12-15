import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * S1 지름길 - https://www.acmicpc.net/problem/1446
 * DFS (다익스트라도 가능) - 시작,도착,거리 가 있는 지름길을 이용하여 원하는 지점에 도착할 때, 최소값 구하기
 *
 * 모든 지름길을 사용한다 OR 안한다로 탐색. 정렬된 상태 + 지금 위치에서 지름길의 시작 위치만큼 가야함.
 */
public class Main {

  static int N, D, answer = Integer.MAX_VALUE;
  static List<Distance> board = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    D = Integer.parseInt(line[1]);
    for (int i = 0; i < N; i++) {
      line = bf.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int c = Integer.parseInt(line[2]);
      if (b - a <= c || b > D) {
        continue;
      }

      board.add(new Distance(a, b, c));
    }
    Collections.sort(board, (o1, o2) -> o1.start - o2.start);

    dfs(0, 0, 0);

    System.out.println(answer);
  }

  static void dfs(int deep, int start, int value) {
    if (deep == board.size()) {
      answer = Math.min(answer, value + (D - start));
      return;
    }
    if (start <= board.get(deep).start) {
      dfs(deep + 1, board.get(deep).end,
          value + board.get(deep).value + board.get(deep).start - start);
    }
    dfs(deep + 1, start, value);
  }

  static class Distance {

    int start, end, value;

    public Distance(int a, int b, int c) {
      start = a;
      end = b;
      value = c;
    }
  }
}
