import java.util.*;
import java.util.stream.*;

class Solution {

  public int[] solution(int[] array, int[][] commands) {
    List<Integer> answer = new ArrayList<>();
    for (int command[] : commands) {
      List<Integer> list = new ArrayList<>();
      for (int i = command[0] - 1; i < command[1]; i++) {
        System.out.println(array[i]);
        list.add(array[i]);
      }
      list = list.stream().sorted().collect(Collectors.toList());
      answer.add(list.get(command[2] - 1));
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }
}