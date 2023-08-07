class Solution {

  public int solution(int a, int b) {
    int x = b / gcd(a, b);

    while (x != 1) {
      if (x % 2 == 0) {
        x /= 2;
      } else if (x % 5 == 0) {
        x /= 5;
      } else {
        return 2;
      }
    }
    return 1;
  }

  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}