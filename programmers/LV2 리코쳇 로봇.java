import java.util.LinkedList;
import java.util.Queue;

/**
 * LV2 리코쳇 로봇 https://school.programmers.co.kr/learn/courses/30/lessons/169199
 * BFS - 최단거리 계산이지만, 이동 시 벽 끝까지 이동할 때, 최소 거리 구하기
 *
 * @!!! 복붙 하던 중 변수명 실수해서, 오래걸림. 오류가 나면 변수명부터 잘 보자
 * @!!! 각 case로 할 필요없었음.. +dx[i] 가 곧 ++ 또는 --임
 */
class Solution {

  int[] dx = new int[]{1, -1, 0, 0};
  int[] dy = new int[]{0, 0, 1, -1};
  int cLen;
  int rLen;

  public int solution(String[] board) {
    int answer = -1;
    int startX = 0, startY = 0, endX = 0, endY = 0;
    int idx = 0;
    for (String s : board) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'R') {
          startX = i;
          startY = idx;
        } else if (s.charAt(i) == 'G') {
          endX = i;
          endY = idx;
        }
      }
      idx++;
    }
    cLen = board.length;
    rLen = board[0].length();
    Queue<int[]> q = new LinkedList<>();
    int[][] visit = new int[board.length][board[0].length()];
    q.add(new int[]{startY, startX, 0});
    while (!q.isEmpty()) {
      int[] tempPoll = q.poll();
      int x = tempPoll[1];
      int y = tempPoll[0];
      int cnt = tempPoll[2];

      for (int i = 0; i < 4; i++) {
        int ax = x;
        int ay = y;
        if (dx[i] == 1) {
          for (int j = 0; j < 100; j++) {
            ax++;
            if (ax == rLen || board[ay].charAt(ax) == 'D') {
              ax--;
              break;
            }
          }
        }
        if (dy[i] == 1) {
          for (int j = 0; j < 100; j++) {
            ay++;
            if (ay == cLen || board[ay].charAt(ax) == 'D') {
              ay--;
              break;
            }
          }
        }

        if (dx[i] == -1) {
          for (int j = 0; j < 100; j++) {
            ax--;
            if (ax < 0 || board[ay].charAt(ax) == 'D') {
              ax++;
              break;
            }
          }
        }

        if (dy[i] == -1) {
          for (int j = 0; j < 100; j++) {
            ay--;
            if (ay < 0 || board[ay].charAt(ax) == 'D') {
              ay++;
              break;
            }
          }
        }
        if (board[ay].charAt(ax) == 'G') {
          return cnt + 1;
        }
        if (visit[ay][ax] == 0) {
          visit[ay][ax] = 1;
          q.add(new int[]{ay, ax, cnt + 1});
        }
      }
    }

    return answer;
  }

}