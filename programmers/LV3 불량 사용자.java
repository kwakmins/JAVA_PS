import java.util.HashSet;
import java.util.Set;

/**
 * @LV3 불량 사용자 https://school.programmers.co.kr/learn/courses/30/lessons/64064
 * 백트래킹 - 모든 문자를 대체하는 *를 포함한 밴 목록으로, 유저들이 벤되는 모든 경우의 수 구하기
 *
 * 2중 set으로 백트래킹.
 * @!!! 중복 배열을 뺄려면 2중 Set이 유용함.
 * @!!! 배열이 짧으면 백트래킹 의심. (맨 처음 조합으로 풀려고 시도했음)
 */
class Solution {

  String[] userIds;
  String[] bannedIds;
  Set<Set<String>> result;

  public int solution(String[] user_id, String[] banned_id) {
    result = new HashSet<>();
    userIds = user_id;
    bannedIds = banned_id;

    dfs(new HashSet<>(), 0);
    return result.size();
  }

  void dfs(Set<String> set, int deep) {
    if (deep == bannedIds.length) {
      result.add(set);
      return;
    }
    for (int i = 0; i < userIds.length; i++) {
      if (set.contains(userIds[i])) {
        continue;
      }

      if (match(bannedIds[deep], userIds[i])) {
        set.add(userIds[i]);
        dfs(new HashSet<>(set), deep + 1);
        set.remove(userIds[i]);
      }
    }
  }

  boolean match(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != '*' && s1.charAt(i) != s2.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}