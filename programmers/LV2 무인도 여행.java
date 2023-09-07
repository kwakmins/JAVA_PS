import java.util.*;

class Solution {

  public int[] solution(String[] maps) {
    List<Integer> answer = new ArrayList<>();
    int dx[] = new int[]{0, 0, 1, -1};
    int dy[] = new int[]{1, -1, 0, 0};
    int[][] map = new int[maps.length][maps[0].length()];
    for (int i = 0; i < maps.length; i++) {
      String[] temps = maps[i].split("");
      for (int j = 0; j < temps.length; j++) {
        if (temps[j].equals("X")) {
          continue;
        }
        map[i][j] = Integer.parseInt(temps[j]);
      }
    }
    int[][] visit = new int[maps.length][maps[0].length()];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        int sum = 0;
        if (map[i][j] != 0 && visit[i][j] == 0) {
          Queue<int[]> q = new LinkedList<>();
          q.add(new int[]{i, j});
          visit[i][j] = 1;
          while (!q.isEmpty()) {
            int x = q.peek()[1];
            int y = q.peek()[0];
            q.poll();
            sum += map[y][x];
            for (int k = 0; k < 4; k++) {
              int ax = x + dx[k];
              int ay = y + dy[k];
              if (ax >= 0 && ay >= 0 && ay < map.length && ax < map[0].length) {
                if (visit[ay][ax] == 0 && map[ay][ax] != 0) {
                  q.add(new int[]{ay, ax});
                  visit[ay][ax] = 1;
                }
              }
            }
          }
        }
        if (sum > 0) {
          answer.add(sum);
        }
      }
    }
    if (answer.isEmpty()) {
      return new int[]{-1};
    }
    return answer.stream().sorted().mapToInt(i -> i).toArray();
  }
}