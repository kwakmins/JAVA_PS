import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[] emergency) {
    List<Integer> em = Arrays.stream(emergency).boxed().collect(Collectors.toList());
    List<Integer> sortEm = em.stream().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < em.size(); i++) {
      answer.add(sortEm.indexOf(em.get(i)) + 1);
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }
}