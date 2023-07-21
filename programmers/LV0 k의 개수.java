class Solution {

  public int solution(int i, int j, int k) {
    int answer = 0;
    String s = Integer.toString(k);
    for (int z = i; z <= j; z++) {
      String temp = Integer.toString(z);
      while (temp.contains(s) == true) {
        temp = temp.replaceFirst(s, "");
        answer++;
      }
    }
    return answer;
  }
}