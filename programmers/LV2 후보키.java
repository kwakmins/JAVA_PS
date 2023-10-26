import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 후보키 https://school.programmers.co.kr/learn/courses/30/lessons/42890
 *
 * 조합 + 비트마스킹 - DB의 후보키 구하기
 *
 * 조합으로 모든 경우의 수를 중복 확인 및 비트마스킹으로 이전에 사용된 부분함수인지 확인
 *
 * @!!! 모든 자리수 조합 구현법 외우기 (for문으로 자리수 정하고, 자리수 채우면 return)
 * @!!! 비트마스킹으로 부분함수처럼 사용 가능
 */
class Solution {

  int len;
  String[][] gRelation;
  int[] visit;
  List<Integer> ans;
  Stack<Integer> s;

  public int solution(String[][] relation) {
    len = relation[0].length;
    gRelation = relation;
    ans = new ArrayList<>();

    for (int i = 1; i <= len; i++) {
      s = new Stack<>();
      visit = new int[len];
      comb(0, i);
    }
    return ans.size();
  }

  void comb(int start, int r) {
    if (r == 0) {
      List<Integer> list = new ArrayList<>();
      for (int i : s) {
        list.add(i);
      }

      if (isSubKey(list)) {
        int x = 0;
        for (int num : list) {
          x |= (1 << num); //원소 추가
        }
        if (!isSubSet(x)) {
          ans.add(x);
        }
      }
      return;
    }

    for (int i = start; i < len; i++) {
      if (visit[i] == 0) {
        visit[i] = 1;
        s.push(i);
        comb(i + 1, r - 1);//i+1
        s.pop();
        visit[i] = 0;
      }
    }
  }

  //유일성 체크 (굳이 list로 안해도 된다)
  boolean isSubKey(List<Integer> list) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < gRelation.length; i++) {
      String data = "";
      for (int j : list) {
        data += gRelation[i][j];
      }
      if (set.contains(data)) {
        return false;
      }
      set.add(data);
    }
    return true;
  }

  boolean isSubSet(int now) {
    for (int i = 0; i < ans.size(); i++) {
      int ansData = ans.get(i);
      if ((ansData & now) == ansData) { //원소 같은지 확인
        return true;
      }
    }
    return false;
  }
}