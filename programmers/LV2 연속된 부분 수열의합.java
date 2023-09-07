import java.util.*;

/***
 * 진행 순서에 따라 필수 포함이 무엇인지 파악하자
 */
class Solution {

  public int[] solution(int[] sequence, int k) {

    Deque<Integer> dq = new LinkedList<>();
    int size = 0;
    int[] answer = {};
    int sum = 0;

    for (int i = 0; i < sequence.length; i++) {
      sum += sequence[i];
      dq.add(i);
      while (sum > k) {
        sum -= sequence[dq.peekFirst()];
        dq.poll();
      }
      if (sum == k) {
        if (size == 0 || dq.size() < size) {
          size = dq.size();
          answer = new int[2];
          answer[0] = dq.peekFirst();
          answer[1] = dq.peekLast();
        }
      }
    }

    return answer;
  }
}