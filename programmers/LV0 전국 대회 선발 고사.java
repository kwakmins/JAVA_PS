import java.util.*;
import java.util.stream.*;

class Solution {

  public int solution(int[] rank, boolean[] attendance) {
    int answer = 0;
    int top = 0;
    List<Integer> list = Arrays.stream(rank).boxed().collect(Collectors.toList());
    int i = 1;
    while (top != 3) {
      if (attendance[list.indexOf(i)]) {
        top++;
        if (top == 1) {
          answer += list.indexOf(i) * 10000;
        } else if (top == 2) {
          answer += list.indexOf(i) * 100;
        } else {
          answer += list.indexOf(i);
        }
      }
      i++;
    }
    return answer;
  }
}