import java.util.LinkedList;
import java.util.Queue;

/**
 * LV2 미로탈출 https://school.programmers.co.kr/learn/courses/30/lessons/159993#
 * DFS - 시작점, 레버 , 벽, 도착점이 주어지고, 시작점 -> 레버 -> 도착점 까지 최단거리 구하기 (중복 가능)
 *
 * @param maps 지도
 * @return 최단 거리
 *
 * 시작점 -> 레버 BFS로 구하고, 방문을 초기화 한 후, 다시 레버 -> 도착점까지 구함.
 * @!!! x와 y 순서 헷갈리지 않게, 무조건 y부터 하자
 */
class Solution {

  int[] dx = new int[]{1, -1, 0, 0};
  int[] dy = new int[]{0, 0, 1, -1};

  public int solution(String[] maps) {
    int answer = 0;
    int sx = 0, sy = 0, ex = 0, ey = 0, lx = 0, ly = 0;

    for (int i = 0; i < maps.length; i++) {
      String s = maps[i];
      System.out.println(s);
      String[] ss = s.split("");
      for (int j = 0; j < ss.length; j++) {
        if (ss[j].equals("S")) {
          sx = j;
          sy = i;
        }
        if (ss[j].equals("L")) {
          lx = j;
          ly = i;
        }
        if (ss[j].equals("E")) {
          ex = j;
          ey = i;
        }
      }
    }
    int[][] visit = new int[maps.length][maps[0].length()];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sx, sy, 0});
    while (!q.isEmpty()) {
      int x = q.peek()[0];
      int y = q.peek()[1];
      int cnt = q.poll()[2];
      if (x == lx && y == ly) {
        answer += cnt;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ax = x + dx[i];
        int ay = y + dy[i];
        if (ax >= 0 && ay >= 0 && ax < maps[0].length() && ay < maps.length) {
          if (maps[ay].charAt(ax) != 'X' && visit[ay][ax] == 0) {
            visit[ay][ax] = 1;
            q.add(new int[]{ax, ay, cnt + 1});
          }
        }
      }
    }
    if (answer == 0) {
      return -1;
    }

    visit = new int[maps.length][maps[0].length()];
    q = new LinkedList<>();
    q.add(new int[]{lx, ly, 0});
    boolean b = false;
    while (!q.isEmpty()) {
      int x = q.peek()[0];
      int y = q.peek()[1];
      int cnt = q.poll()[2];
      if (x == ex && y == ey) {
        answer += cnt;
        b = true;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ax = x + dx[i];
        int ay = y + dy[i];
        if (ax >= 0 && ay >= 0 && ax < maps[0].length() && ay < maps.length) {
          if (maps[ay].charAt(ax) != 'X' && visit[ay][ax] == 0) {
            visit[ay][ax] = 1;
            q.add(new int[]{ax, ay, cnt + 1});
          }
        }
      }
    }
    if (!b || answer == 0) {
      return -1;
    }

    return answer;
  }
}