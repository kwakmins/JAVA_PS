class Solution {

  public int[] solution(int numer1, int denom1, int numer2, int denom2) {
    int x = denom1 * denom2 / gcd(denom1, denom2);
    int temp = x / denom1 * numer1 + x / denom2 * numer2;
    return new int[]{temp / gcd(temp, x), x / gcd(temp, x)};
  }

  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}