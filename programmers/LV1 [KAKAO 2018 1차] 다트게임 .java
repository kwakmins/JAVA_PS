import java.util.*;

class Solution {

  public int solution(String dartResult) {

    List<Integer> arr = new ArrayList<>();
    arr.add(0);
    for (int i = 0; i < dartResult.length(); i++) {
      int len = arr.size();
      if (dartResult.charAt(i) == 'S') {
        arr.add(0);
      } else if (dartResult.charAt(i) == 'D') {
        arr.set(len - 1, (int) Math.pow(arr.get(len - 1), 2));
        arr.add(0);
      } else if (dartResult.charAt(i) == 'T') {
        arr.set(len - 1, (int) Math.pow(arr.get(len - 1), 3));
        arr.add(0);
      } else if (dartResult.charAt(i) == '*') {
        arr.set(len - 2, arr.get(len - 2) * 2);
        if (len > 2) {
          arr.set(len - 3, arr.get(len - 3) * 2);
        }
      } else if (dartResult.charAt(i) == '#') {
        arr.set(len - 2, arr.get(len - 2) * -1);
      } else {
        arr.set(len - 1, arr.get(len - 1) * 10 + dartResult.charAt(i) - '0');
      }
    }

    return arr.stream().mapToInt(i -> i).sum();
  }
}