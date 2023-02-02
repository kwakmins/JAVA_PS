class Solution {

  int cal(int n) {
    int sum = 0;
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        if (i * i == n) {
          sum += 1;
        } else {
          sum += 2;
        }
      }
    }
    return sum;
  }

  public int solution(int left, int right) {
    int answer = 0;
    for (int i = left; i <= right; i++) {
      int n = cal(i);
      if (n % 2 == 0) {
        answer += i;
      } else {
        answer -= i;
      }
    }
    return answer;
  }
}