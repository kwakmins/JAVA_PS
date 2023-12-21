import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LV2 혼자 놀기의 달인 - https://school.programmers.co.kr/learn/courses/30/lessons/131130
 * 구현 ,탐색 - index 숫자가 들어간 상자 배열을 연계해서 열 때, 2번 반복할 때의 최대 곱한값 구하기
 *
 * 탐색이 끝나면 list에 추가 후, 내림차순 정렬 후 2개 뽑아서 곱하기
 */
class Solution {

  boolean[] visit;
  int[] cards;
  List<Integer> list = new ArrayList<>();

  public int solution(int[] cards) {
    int answer = 0;
    this.cards = cards;
    visit = new boolean[cards.length + 1];

    for (int i = 1; i <= cards.length; i++) {
      if (!visit[i]) {
        list.add(dfs(i, 0));
      }
    }
    if (list.size() <= 1) {
      return 0;
    }
    Collections.sort(list, (o1, o2) -> o2 - o1);

    return list.get(0) * list.get(1);
  }

  int dfs(int x, int cnt) {
    visit[x] = true;
    cnt += 1;
    if (!visit[cards[x - 1]]) {
      return dfs(cards[x - 1], cnt);
    }
    return cnt;
  }
}