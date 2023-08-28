class Solution {

  int[] arr;

  public long solution(int n) {
    arr = new int[n + 1];
    return dp(n);
  }

  int dp(int n) {
    if (arr[n] == 0) {
      if (n == 1) {
        arr[n] = 1;
      } else if (n == 2) {
        arr[n] = 2;
      } else {
        arr[n] = (dp(n - 1) + dp(n - 2)) % 1234567;
      }
    }
    return arr[n];
  }
}