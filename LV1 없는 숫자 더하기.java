class Solution {

  public int solution(int[] numbers) {
    int answer = 0;
    int visit[] = new int[10];
    for (int i : numbers) {
      visit[i] = 1;
    }
    for (int i = 0; i < 10; i++) {
      if (visit[i] == 0) {
        answer += i;
      }
    }
    return answer;
  }
}