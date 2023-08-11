import java.util.*;

class Solution {

  public String solution(String[] participant, String[] completion) {
    Map<String, Integer> map = new HashMap<>();
    Arrays.stream(participant).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
    for (String s : completion) {
      map.put(s, map.get(s) - 1);
    }
    for (String s : participant) {
      if (map.get(s) >= 1) {
        return s;
      }
    }
    return "";
  }
}