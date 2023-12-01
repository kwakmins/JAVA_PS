import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LV3 여행경로 - https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * 백트래킹 - 모든 여행지를 가는 경로 순서 구하기. 여러개면 알파벳 사전상 순서가 앞인 목적지 부터.
 *
 * 도착지 기준으로 정렬을 하여, 맨 처음 모든 여행지를 가는 경우 구함
 */
class Solution {

  String[][] tickets;
  boolean[] visit;
  int n;
  List<String> answer;

  public String[] solution(String[][] tickets) {
    Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
    this.tickets = tickets;
    List<String> list;
    list = new ArrayList<>();
    answer = new ArrayList<>();
    n = tickets.length;
    visit = new boolean[n];
    list.add("ICN");
    dfs("ICN", 0, list);

    return answer.stream().toArray(String[]::new);
  }

  void dfs(String start, int cnt, List<String> list) {
    if (answer.size() >= 1) {
      return;
    }
    if (cnt == n) {
      for (int i = 0; i < list.size(); i++) {
        answer.add(list.get(i));
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        if (tickets[i][0].equals(start)) {
          visit[i] = true;
          list.add(tickets[i][1]);
          dfs(tickets[i][1], cnt + 1, list);
          list.remove(list.size() - 1);
          visit[i] = false;
        }
      }
    }
  }
}