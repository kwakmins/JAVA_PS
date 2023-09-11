import java.util.*;

class Solution {

  public String[] solution(String[] files) {

    return Arrays.stream(files).sorted((a, b) -> comp(a, b)).toArray(String[]::new);
  }

  public int comp(String a, String b) {
    String aHead = "", bHead = "";
    int aNumberIdx = 0, bNumberIdx = 0;
    for (String s : a.toLowerCase().split("")) {
      if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
        aNumberIdx = a.indexOf(s);
        break;
      }
      aHead += s;
    }
    for (String s : b.toLowerCase().split("")) {
      if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
        bNumberIdx = b.indexOf(s);
        break;
      }
      bHead += s;
    }
    int x = aHead.compareTo(bHead);
    if (x != 0) {
      return x;
    }
    String aNumber = "", bNumber = "";
    for (String s : a.substring(aNumberIdx, a.length()).split("")) {
      if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
        aNumber += s;
      } else {
        break;
      }
    }
    for (String s : b.substring(bNumberIdx, b.length()).split("")) {
      if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
        bNumber += s;
      } else {
        break;
      }
    }
    return Integer.parseInt(aNumber) - Integer.parseInt(bNumber);
  }
}