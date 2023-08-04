import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[][] score) {
    List<Integer> answer = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int[] sco : score) {
      list.add(sco[0] + sco[1]);
    }
    list = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    for (int[] sco : score) {
      answer.add(list.indexOf(sco[0] + sco[1]) + 1);
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }
}