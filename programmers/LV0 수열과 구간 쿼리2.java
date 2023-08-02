import java.util.*;

class Solution {

  public int[] solution(int[] arr, int[][] queries) {
    int[] answer = {};
    List<Integer> list = new ArrayList<>();
    for (int[] query : queries) {
      int min = 1000001;
      for (int i = query[0]; i <= query[1]; i++) {
        if (arr[i] > query[2]) {
          min = Math.min(arr[i], min);
        }
      }
      if (min != 1000001) {
        list.add(min);
      } else {
        list.add(-1);
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}