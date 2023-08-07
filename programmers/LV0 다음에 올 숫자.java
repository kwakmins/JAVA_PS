class Solution {

  public int solution(int[] common) {
    boolean isGeo = false;
    int x;
    if (common[1] - common[0] != common[2] - common[1]) {
      isGeo = true;
    }
    if (isGeo) {
      x = common[1] / common[0];
      return x * common[common.length - 1];
    } else {
      x = common[1] - common[0];
      return x + common[common.length - 1];
    }
  }
}