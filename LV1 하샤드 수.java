import java.util.*;

class Solution {

  public boolean solution(int x) {
    boolean answer = true;
    String[] arr = String.valueOf(x).split("");
    int result = 0;

    for (int i = 0; i < arr.length; i++) {
      result += Integer.valueOf(arr[i]);
    }
    if (x % result != 0) {
      return false;
    }
    return answer;
  }
}