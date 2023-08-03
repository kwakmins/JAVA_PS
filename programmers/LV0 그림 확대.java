import java.util.*;

class Solution {

  public String[] solution(String[] picture, int k) {
    String[] answer = {};
    List<String> list = new ArrayList<>();
    for (String s : picture) {
      for (int i = 0; i < k; i++) {
        String temp = "";
        for (char c : s.toCharArray()) {
          for (int j = 0; j < k; j++) {
            temp += c;
          }
        }
        list.add(temp);
      }
    }
    return list.toArray(String[]::new);
  }
}