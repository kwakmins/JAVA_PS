import java.util.*;

class Solution {

  public int[] solution(String myString) {

    List<Integer> li = new ArrayList<>();
    String[] mys = myString.split("x", -1);
    for (String s : mys) {
      li.add(s.length());
    }
    return li.stream().mapToInt(i -> i).toArray();
  }
}