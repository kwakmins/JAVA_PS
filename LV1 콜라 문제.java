class Solution {
  public int solution(int a, int b, int n) {
    int answer = 0;
    while(n>=a){
      int x = n/a;
      answer+=b*x;
      n = b*x + n%a;
    }
    return answer;
  }
}