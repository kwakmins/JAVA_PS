class Solution {

  public int solution(String[] strArr) {
    int answer = 0;
    int a[] = new int[31];
    for (String s : strArr) {
      int len = s.length();
      a[len]++;
      if (a[len] > answer) {
        answer = a[len];
      }
    }
    return answer;
  }
}