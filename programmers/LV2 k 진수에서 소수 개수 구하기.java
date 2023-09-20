class Solution {

  public int solution(int n, int k) {
    int answer = 0;
    String[] s = Integer.toString(n, k).split("0");
    for (String ss : s) {
      if (!ss.equals("") && isPrime(Long.parseLong(ss))) {
        answer++;
      }
    }
    return answer;
  }

  public boolean isPrime(long x) {
    if (x == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }
}