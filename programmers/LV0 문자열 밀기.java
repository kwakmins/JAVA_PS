import java.util.*;

class Solution {

  public int solution(String A, String B) {
    if (A.equals(B)) {
      return 0;
    }
    StringBuilder right = new StringBuilder(A);
    int rightCnt = 0;
    for (int i = 0; i < A.length(); i++) {
      right.insert(0, right.charAt(right.length() - 1));
      right.delete(right.length() - 1, right.length());
      if (right.toString().equals(B)) {
        rightCnt = i + 1;
        break;
      }
    }
    if (rightCnt != 0) {
      return rightCnt;
    }
    return -1;
  }
}