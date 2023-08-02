import java.util.*;

class Solution {

  public String solution(String my_string, int[][] queries) {
    String answer = "";
    StringBuilder sb = new StringBuilder(my_string);
    for (int[] i : queries) {
      String s = new StringBuilder(sb.substring(i[0], i[1] + 1)).reverse().toString();
      sb = sb.replace(i[0], i[1] + 1, s);
    }
    return sb.toString();
  }
}