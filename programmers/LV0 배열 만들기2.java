import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

  public int[] solution(int l, int r) {
    List<Integer> list = new ArrayList<>();
    for (int i = l; i <= r; i++) {
      Boolean b = true;
      for (String s : String.valueOf(i).split("")) {
        if (!s.equals("5") && !s.equals("0")) {
          b = false;
          break;
        }
      }
      if (b) {
        list.add(i);
      }
    }
    if (list.size() != 0) {
      return list.stream().mapToInt(i -> i).toArray();
    } else {
      return new int[]{-1};
    }
  }
}

class Solution2 {

  public int[] solution(int l, int r) {
    List<Integer> filtered = IntStream.rangeClosed(l, r)
        .filter(num -> String.valueOf(num).chars().allMatch(ch -> ch == '0' || ch == '5'))
        .boxed()
        .collect(Collectors.toList());
    return filtered.isEmpty() ? new int[]{-1}
        : filtered.stream().mapToInt(Integer::intValue).toArray();
  }
}