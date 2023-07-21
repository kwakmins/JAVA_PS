class Solution {

  int era[] = new int[10000001];

  void eratos(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (era[i] == 0) {
        for (int j = i + i; j <= n; j += i) {
          era[j] = 1;
        }
      }
    }
  }

  public int solution(int n) {
    int answer = 0;
    eratos(n);
    for(int i=2;i<=n;i++){
      if(era[i]==0){
        answer++;
      }
    }
    return answer;
  }
}