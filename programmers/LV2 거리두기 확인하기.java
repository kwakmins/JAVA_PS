import java.util.ArrayList;
import java.util.List;

/**
 * LV2 거리두기 확인하기 https://school.programmers.co.kr/learn/courses/30/lessons/81302#fn1
 * BFS - 사람이 있는 자리 맨해튼 거리안에 다른 사람이 있는지 확인하기 (벽이 있으면 괜찮다)
 *
 * @param 문제 맵 케이스
 * @return 문제 맵 케이스에 대한 답
 *
 * 모든 사람이 있는 자리를 배열로 담아, 해당 배열에 대해 DFS를 돌려, 맨해튼 거리 및 방문 여부 등을 확인 하는 ax ay에 대해
 * P이면 return false O면 다시 DFS 진행
 * @!!! X면 DFS를 하지 않아 진행하지 못한다는 발상 못함.
 * @!!! 문제를 읽고 알고리즘을 찾는 연습 필요. - 너무 어렵게 생각함
 */
class Solution {

  List<int[]> list;
  int[] dx = new int[]{1, -1, 0, 0};
  int[] dy = new int[]{0, 0, 1, -1};
  String[] gPlace;
  boolean flag;
  int[][] visit;

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];

    for (int t = 0; t < places.length; t++) {
      String[] place = places[t];
      gPlace = place;
      list = new ArrayList<>();
      flag = false;

      for (int i = 0; i < place.length; i++) {
        for (int j = 0; j < place[i].length(); j++) {
          char c = place[i].charAt(j);
          if (c == 'P') {
            list.add(new int[]{i, j});
          }
        }
      }
      int temp = 1;
      for (int[] people : list) {
        flag = false;
        visit = new int[place.length][place[0].length()];
        visit[people[0]][people[1]] = 1;
        dfs(people[0], people[1], people[0], people[1]);
        if (flag) {
          temp = 0;
          break;
        }
      }

      answer[t] = temp;
    }
    return answer;
  }

  void dfs(int y, int x, int y2, int x2) {
    for (int i = 0; i < 4; i++) {
      int ax = x2 + dx[i];
      int ay = y2 + dy[i];

      if (ax >= 0 && ay >= 0 && ay < gPlace.length && ax < gPlace[ay].length()
          && visit[ay][ax] == 0) {
        if (Math.abs(x - ax) + Math.abs(y - ay) <= 2) {
          if (gPlace[ay].charAt(ax) == 'P') {
            flag = true;
            return;
          } else if (gPlace[ay].charAt(ax) == 'O') {
            visit[ay][ax] = 1;
            dfs(y, x, ay, ax);
          }
        }
      }
    }
  }
}