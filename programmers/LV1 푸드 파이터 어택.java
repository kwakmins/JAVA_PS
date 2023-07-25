class Solution {

  public String solution(int[] food) {

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < food.length; i++) {
      for (int q = 0; q < food[i] / 2; q++) {
        sb.append(i);
      }
    }
    String answer = sb.toString() + "0" + sb.reverse();
    return answer;
  }
}