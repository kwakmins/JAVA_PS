import java.util.*;
import java.util.stream.*;

/**
 * foreach 할때 else문 조심!!
 */
class Solution {

  String[] gp;

  public String solution(String p) {
    gp = p.split("");
    return fb("", p, 0, 0, 0, "");
  }

  public String fb(String u, String v, int left, int right, int i, String answer) {
    if (v.equals("")) {
      return answer;
    }
    if (gp[i].equals("(")) {
      left++;
      u += "(";
    } else {
      right++;
      u += ")";
    }

    if (left == right) {
      left = 0;
      right = 0;
      v = String.join("", gp)
          .substring(i + 1, gp.length);
      Stack<String> stack = new Stack<>();
      for (String s : u.split("")) {
        if (!stack.isEmpty() && stack.peek().equals("(") && s.equals(")")) {
          stack.pop();
        } else {
          stack.add(s);
        }
      }
      if (stack.isEmpty()) {
        answer += u;
        u = "";
      } else {
        String temp = "(";
        temp += fb("", v, 0, 0, i + 1, "") + ")";
        //foreach 할때 else문 조심!!
        for (String s : u.substring(1, u.length() - 1).split("")) {
          if (s.equals(")")) {
            temp += "(";
          } else if (s.equals("(")) {
            temp += ")";
          }
        }
        System.out.println(temp);
        return answer + temp;
      }
    }

    return fb(u, v, left, right, i + 1, answer);
  }
}