class Solution {
  public static long solution(int k, int d) {
    long answer = 0;
    long x = (long) d * d;

    for(long i=0; i<=d; i+=k){
      answer += (long) Math.sqrt(x-i*i)/k+1;
    }
    return answer;
  }
}
