import java.util.LinkedList;
import java.util.Queue;

/**
 * LV2 게임 맵 최단거리 - https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java
 * BFS - 미로 찾기
 */
class Solution {

  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};

  public int solution(int[][] maps) {
    int answer = -1;
    Queue<int[]> q = new LinkedList<>();
    int[][] visit = new int[maps.length][maps[0].length];

    q.add(new int[]{0, 0, 1});

    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int x = arr[1];
      int y = arr[0];
      int cnt = arr[2];
      if (y == maps.length - 1 && x == maps[0].length - 1) {
        return cnt;
      }

      for (int i = 0; i < 4; i++) {
        int ax = x + dx[i];
        int ay = y + dy[i];
        if (ay >= 0 && ax >= 0 && ax < maps[0].length && ay < maps.length) {
          if (visit[ay][ax] == 0 && maps[ay][ax] == 1) {
            visit[ay][ax] = 1;
            q.add(new int[]{ay, ax, cnt + 1});
          }
        }
      }
    }
    return answer;
  }
}