import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[] arr, int k) {
    int[] answer = new int[k];
    Arrays.fill(answer, -1);
    Set<Integer> set = new LinkedHashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));

    int i = 0;
    for (int num : set) {
      answer[i] = num;
      if (i == k - 1) {
        break;
      }
      i++;
    }

    return answer;
  }
}