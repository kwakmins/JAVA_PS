class Solution {

  public long solution(int price, int money, int count) {
    long answer = 0;
    int x = price;
    for (int i = 0; i < count; i++) {
      answer += x;
      x += price;
    }
    answer -= money;
    if (answer <= 0) {
      return 0;
    }
    return answer;
  }
}