/**
 * @LV3 기지국 설치 - https://school.programmers.co.kr/learn/courses/30/lessons/12979
 * 그리드 - N개의 아파트가 모두 전파를 사용 가능 하도록 범위가 W인 기지국 설치 하는 최소 개수
 *
 * 주어진 기지국으로 기지국 설치가 필요한 개수를 구한다.
 * - N개의 아파트를 순환하는 변수 t로 t가 N개가 될 때 까지,
 * - 기지국이 없으면 't = W * 2 + 1' , 기지국 설치 cnt +1
 * - 기지국이 있으면 주어진 기지국을 순환하는 idx + 1 , 't = 기지국 위치[idx] + w + 1'
 * .
 * @!!! N이 2억이면 O(N)도 피하자
 */
class Solution {

  public int solution(int n, int[] stations, int w) {
    int cnt = 0;
    int idx = 0;
    int t = 1;
    while (t <= n) {
      if (idx < stations.length && stations[idx] - w <= t) {
        t = stations[idx] + w + 1;
        idx++;
      } else {
        t += w * 2 + 1;
        cnt += 1;
      }
    }
    return cnt;
  }
}

/* 배열로 풀려함
 class Solution2 {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int idx = 0;
        int t = 1;
        while(t<=n){
            if(idx<stations.length && stations[idx]-w <= t){
                t = stations[idx]+w+1;
                idx++;
            } else {
                t+=w*2 +1;
                cnt+=1;
            }
        }
        return cnt;
    }
}

 */