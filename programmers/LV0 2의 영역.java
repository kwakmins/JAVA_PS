import java.util.*;

class Solution {

  public int[] solution(int[] arr) {
    int[] answer = {};
    List<Integer> list = new ArrayList<>();
    int x = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 2) {
        if (x == -1) {
          list.add(arr[i]);
          x = i + 1;
        } else {
          for (int j = x; j <= i; j++) {
            list.add(arr[j]);
          }
          x = i + 1;
        }
      }
    }
    return list.size() > 0 ? list.stream().mapToInt(i -> i).toArray() : new int[]{-1};
  }
}