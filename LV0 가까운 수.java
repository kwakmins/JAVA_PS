import java.util.*;
import java.util.stream.Collectors;

class Solution {

  public int solution(int[] array, int n) {
    int answer = 0;
    List<Integer> li = Arrays.stream(array).boxed().collect(Collectors.toList());
    if (li.contains(n)) {
      return n;
    }
    li.add(n);
    Collections.sort(li);

    int x = 0, y = 0;

    for (int i = 0; i < li.size(); i++) {
      if (li.get(i) == n) {
        if (i == 0) {
          return li.get(i + 1);
        }
        if (i == li.size() - 1) {
          return li.get(i - 1);
        }

        x = li.get(i - 1);
        y = li.get(i + 1);
      }
    }

    return Math.abs(x - n) <= Math.abs(y - n) ? x : y;
  }
}