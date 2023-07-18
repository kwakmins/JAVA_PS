import java.util.*;
import java.util.stream.Collectors;

class Solution {

  public int[] solution(int[] arr, int[][] queries) {
    for (int[] query : queries) {
      int temp = arr[query[0]];
      arr[query[0]] = arr[query[1]];
      arr[query[1]] = temp;
    }
    return arr;
  }
}


class Solution2 {

  public List<Integer> solution(int[] arr, int[][] queries) {
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    for (int[] query : queries) {
      Collections.swap(list, query[0], query[1]);
    }
    return list;
  }
}