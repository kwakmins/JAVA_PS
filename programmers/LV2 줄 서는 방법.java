import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * dq의 pop은 Stack이랑 다르니까 poll만 쓰자 순열 효율 X
 * 팩토리얼 지식 부족하면 절대 못맞추는 문제..
 */

class Solution {

  public int[] solution(int n, long k) {
    int[] answer = new int[n];
    List<Integer> list = new ArrayList<>();
    long f = 1;
    for (int i = 1; i <= n; i++) {
      list.add(i);
      f *= i;
    }

    k--;
    int idx = 0;
    while (idx < n) {
      f /= n - idx;
      answer[idx++] = list.remove((int) (k / f));
      k %= f;
    }
    return answer;
  }
}

class Solution2 {

  int[] visit;
  int N;
  long K, cnt = 0;
  Deque<Integer> dq = new LinkedList<>();

  public int[] solution(int n, long k) {
    visit = new int[n];
    N = n;
    K = k;
    dfs();
    int[] answer = new int[n];

    return answer;
  }

  void dfs() {
    if (cnt >= K) {
      return;
    }
    if (dq.size() == N) {
      cnt++;
      return;
    }
    for (int i = 0; i < N; i++) {
      if (visit[i] == 0) {
        visit[i] = 1;
        dq.addLast(i + 1);
        dfs();
        dq.pollLast();
        visit[i] = 0;
      }
    }
  }
}