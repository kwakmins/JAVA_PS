import java.util.*;
import java.util.stream.*;

class Solution {

  public int solution(int[] d, int budget) {
    int answer = 0;
    List<Integer> list = Arrays.stream(d).sorted().boxed().collect(Collectors.toList());
    for (int i = 0; i < list.size(); i++) {
      answer += list.get(i);
      if (answer > budget) {
        return i;
      }
    }
    return list.size();
  }
}