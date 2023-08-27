import java.util.*;

class Solution {

  int Y, N, answer;
  int[] visit = new int[30000001];

  public int solution(int x, int y, int n) {
    answer = -1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, 0});
    while (!q.isEmpty()) {
      int a = q.peek()[0];
      int dep = q.peek()[1];
      q.poll();
      if (a == y) {
        answer = dep;
        break;
      }
      if (a > y) {
        continue;
      }
      if (visit[a + n] == 0) {
        q.add(new int[]{a + n, dep + 1});
        visit[a + n] = 1;
      }
      if (visit[a * 2] == 0) {
        q.add(new int[]{a * 2, dep + 1});
        visit[a * 2] = 1;
      }
      if (visit[a * 3] == 0) {
        q.add(new int[]{a * 3, dep + 1});
        visit[a * 3] = 1;
      }
    }
    return answer;
  }
}