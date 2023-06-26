class Solution {

  public int gcd(int w, int h) {
    if (h == 0) {
      return w;
    } else {
      return gcd(h, w % h);
    }
  }

  public long solution(int w, int h) {
    int x = gcd(w, h);
    long result = (long) w * (long) h - ((long) w + (long) h - x);
    return result;
  }

}