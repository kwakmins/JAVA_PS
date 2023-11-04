import java.util.LinkedList;
import java.util.Queue;

/**
 * LV3 단어 변환 https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * DFS/BFS - 단어 A를 단어 B로 변환 시켜야하는데, 단어 A는 한글자만 변경하여, words에 있는 단어로만 변환 가능.
 *
 * BFS로 바꿀 수 있는 단어 방문 처리 + 방문 후 cnt 증가
 */
class Solution {

  public int solution(String begin, String target, String[] words) {
    int answer = 0;
    Queue<int[]> q = new LinkedList<>();
    int[] visit = new int[words.length];

    boolean b = false;
    for (String s : words) {
      if (s.equals(target)) {
        b = true;
      }
    }
    if (!b) {
      return answer;
    }

    for (int i = 0; i < words.length; i++) {
      if (comp(begin, words[i])) {
        q.add(new int[]{i, 1});
        visit[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int[] po = q.poll();
      int idx = po[0];
      int cnt = po[1];

      if (words[idx].equals(target)) {
        answer = cnt;
        break;
      }

      for (int i = 0; i < words.length; i++) {
        if (visit[i] == 0 && comp(words[idx], words[i])) {
          q.add(new int[]{i, cnt + 1});
          visit[i] = 1;
        }
      }
    }

    return answer;
  }

  boolean comp(String s1, String s2) {
    int x = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        x++;
      }
      if (x == 2) {
        return false;
      }
    }

    return true;
  }
}