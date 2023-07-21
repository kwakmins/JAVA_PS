import java.util.*;

class Solution {

  public int[] solution(int n, int s) {
    int[] answer = null;

    if (n > s) {
      return new int[]{-1};
    }
    answer = new int[n];
    Arrays.fill(answer, s / n);
    for (int i = s % n, j = answer.length - 1; i > 0; i--, j--) {
      answer[j] += 1;
    }

    return answer;
  }
}