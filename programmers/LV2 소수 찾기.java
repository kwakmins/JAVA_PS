/***
 * 소수 판별을 할 때, 에라토스테네스의 채 쓰는건 비효율
 */

class Solution {

  int NUM = 10000000;
  int[] era = new int[NUM];
  ;
  int[] visit = new int[8];
  String[] gNumbers;
  int answer = 0;

  public int solution(String numbers) {
    gNumbers = numbers.split("");
    era[0] = 1;
    era[1] = 1;
    for (int i = 2; i <= Math.sqrt(NUM); i++) {
      for (int j = i + i; j < NUM; j += i) {
        era[j] = 1;
      }
    }
    dfs("");

    return answer;
  }

  void dfs(String x) {
    if (!x.equals("") && era[Integer.parseInt(x)] == 0) {
      era[Integer.parseInt(x)] = 1;
      answer++;
    }

    for (int i = 0; i < gNumbers.length; i++) {
      if (visit[i] == 0) {
        visit[i] = 1;
        dfs(x + gNumbers[i]);
        visit[i] = 0;
      }
    }
  }
}