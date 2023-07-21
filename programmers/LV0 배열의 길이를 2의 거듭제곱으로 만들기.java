import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[] arr) {
    int[] v = new int[100001];
    for (int i = 1; i <= 100000; i *= 2) {
      v[i] = 1;
    }

    List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
    int x = li.size();
    for (int i = x; i < 1000001; i++) {
      if (v[i] == 1) {
        break;
      }
      li.add(0);
    }
    return li.stream().mapToInt(i -> i).toArray();

  }
}