import java.util.*;

class Solution {

  public int solution(String[] spell, String[] dic) {
    int[] alpha = new int[26];
    for (String s : spell) {
      alpha[s.charAt(0) - 'a']++;
    }
    for (String s : dic) {
      int[] temp = alpha.clone();
      boolean b = true;
      for (char c : s.toCharArray()) {
        if (alpha[c - 'a'] > 0) {
          temp[c - 'a'] = 0;
        } else {
          b = false;
          break;
        }
      }
      if (b && Arrays.stream(temp).sum() == 0) {
        return 1;
      }
    }
    return 2;
  }
}