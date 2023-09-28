import java.util.*;

class Solution {

  Set<Integer> set;
  int[] array;

  public int solution(int[] elements) {
    set = new HashSet<>();
    array = elements;
    for (int i = 1; i <= elements.length; i++) {
      cal(i);
    }
    return set.size();
  }

  void cal(int len) {
    for (int i = 0; i < array.length; i++) {
      int sum = 0;
      for (int j = i; j < i + len; j++) {
        if (j >= array.length) {
          sum += array[j - array.length]; // 퍼센트가 더좋다 array[i%array.length]
        } else {
          sum += array[j];
        }
      }
      set.add(sum);
    }
  }
}