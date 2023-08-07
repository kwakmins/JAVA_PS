import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[] arr, int[] query) {
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    for (int i = 0; i < query.length; i++) {
      List<Integer> temp = new ArrayList<>();
      if ((i + 1) % 2 == 1) {
        for (int j = 0; j <= query[i]; j++) {
          temp.add(list.get(j));
        }
        list = List.copyOf(temp);
      } else {
        for (int j = query[i]; j < list.size(); j++) {
          temp.add(list.get(j));
        }
        list = List.copyOf(temp);
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}