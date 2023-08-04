import java.util.*;

class Solution {

  public String solution(String[] id_pw, String[][] db) {
    String answer = "";
    Map<String, String> map = new HashMap<>();
    for (String[] s : db) {
      map.put(s[0], s[1]);
    }
    if (map.containsKey(id_pw[0])) {
      if (map.get(id_pw[0]).equals(id_pw[1])) {
        return "login";
      }
      return "wrong pw";
    }
    return "fail";
  }
}