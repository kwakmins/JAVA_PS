/**
 * 진수는 문자열이 거꾸로 되어있어서 헷갈림 주의.
 */

import java.util.*;

class Solution {

  public long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      answer[i] = fx(numbers[i]);
    }
    return answer;
  }

  public long fx(long x) {
    if (x % 2 == 0) {
      return x + 1;
    }
    String s = Long.toString(x, 2);
    int idx = s.lastIndexOf("0");
    if (idx > 0) {
      s = s.substring(0, idx) + "10" + s.substring(idx + 2, s.length());
    } else {
      s = "10" + s.substring(1, s.length());
    }
    return Long.parseLong(s, 2);
  }
}