import java.util.*;

class Solution {

  public int solution(int k, int m, int[] score) {
    int answer = 0;
    Arrays.sort(score);

    int cnt = score.length / m;
    int idx = score.length - 1;
    while (cnt > 0) {
      int min = k;
      for (int i = 0; i < m; i++) {
        if (min > score[idx]) {
          min = score[idx];
        }
        idx--;
      }
      answer += min * m;
      cnt--;
    }

    return answer;
  }
}