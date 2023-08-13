import java.util.*;

class Solution {

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    List<Integer> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      map.put(name[i], yearning[i]);
    }
    for (String[] s : photo) {
      int score = 0;
      for (String ss : s) {
        score += map.getOrDefault(ss, 0);
      }
      list.add(score);
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}