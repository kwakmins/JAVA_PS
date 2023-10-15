import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257?language=java 
 * 주어진 식의 연산자의 우선순위 중 절대값이 가장 큰 값 찾기
 * @method "100-200*300-500+20"
 * @return 60420
 * 
 * 순열을 해서 모든 우선순위의 순서를 구해, 경우의 수 모두 계산.
 * 한 문자열로 되어있는 식을 직접 list로 숫자,연산자를 나눔.
 * list의 set과 remove를 이용하여 우선순위에 맞게 계산 후 가장 큰지 계산
 */
class Solution {

  String[] ca = new String[]{"+", "-", "*"};
  long max = 0;
  int[] visit = new int[3];
  List<String> express = new ArrayList<>();

  public long solution(String expression) {
    int start = 0;

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '-' || c == '+' || c == '*') {
        express.add(expression.substring(start, i));
        express.add(String.valueOf(c));
        start = i + 1;
      }
    }
    express.add(expression.substring(start, expression.length()));
    dfs(new ArrayList<String>());
    return max;
  }

  void dfs(List<String> list) {
    if (list.size() == 3) {
      List<String> tempList = new ArrayList<>(express);//깊은복사
      for (int i = 0; i < 3; i++) {
        String temp = list.get(i);
        for (int j = 0; j < tempList.size(); j++) {
          if (tempList.get(j).equals(temp)) {
            tempList.set(j - 1, cal(tempList.get(j - 1), temp, tempList.get(j + 1)));
            tempList.remove(j);
            tempList.remove(j);
            j--;
          }
        }
      }
      max = Math.max(max, Math.abs(Long.parseLong(tempList.get(0))));
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (visit[i] == 0) {
        visit[i] = 1;
        list.add(ca[i]);
        dfs(list);
        list.remove(list.size() - 1);
        visit[i] = 0;
      }
    }
  }

  String cal(String num1, String s, String num2) {
    if (s.equals("+")) {
      return String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
    }
    if (s.equals("-")) {
      return String.valueOf(Long.parseLong(num1) - Long.parseLong(num2));
    }
    if (s.equals("*")) {
      return String.valueOf(Long.parseLong(num1) * Long.parseLong(num2));
    }
    return "";
  }
}