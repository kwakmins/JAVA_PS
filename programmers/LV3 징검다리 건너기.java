/**
 * @LV3 징검다리 건너기 https://school.programmers.co.kr/learn/courses/30/lessons/64062?language=java
 * 이분탐색 - 지날 때 마다 -1씩 되는 돌을 건널 때 0이 되면 K를 이용한 뛰어넘기가 안될 때 최대 건널 수 있는 사람 수 구하기
 *
 * 사람이 건널 수 있는 최대 수(1 이상 200,000,000 이하)로 이분탐색.
 * 이분탐색의 판별이 되는 건널 수 있다 없다는 못건널 때 마다 cnt 증가 후 건널 수 있으면 cnt 초기화. cnt가 k값이 되면 건널 수 없다.
 * .
 * @!!! 시간 복잡도 계산을 잘하자! 억 단위면 이분탐색도 생각해보자
 */
class Solution {

  int[] array;
  int kk;

  public int solution(int[] stones, int k) {
    int answer = 0;
    array = stones;
    kk = k;
    int start = 1;
    int end = 200000000;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (bin(mid)) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return answer;
  }

  boolean bin(int mid) {
    int cnt = 0;
    for (int a : array) {
      if (a < mid) {
        cnt++;
      }
      if (cnt == kk) {
        return false;
      }
      if (a >= mid) {
        cnt = 0;
      }
    }
    return true;
  }
}

// k와 stones 200,000 * 200,000임. 억 단위 시간복잡도.
// class Solution3 {
//     public int solution(int[] stones, int k) {
//         int answer = 0;
//         int[] result = new int[stones.length];
//         for(int i=0;i<stones.length;i++){
//             int temp = stones[i];
//             for(int j=i+1;j<i+k;j++){
//                 if(j>=stones.length){
//                     temp = 99999999;
//                     break;
//                 }
//                 temp = Math.max(temp,stones[j]);
//             }
//             result[i] =temp;
//         }
//         return Arrays.stream(result).min().orElseThrow();

//     }
// }

// 거의 완전 탐색. 200,000,000 * 200,000 * 200,000
// class Solution2 {
//     public int solution(int[] stones, int k) {
//         int answer = 0;
//         answer += Arrays.stream(stones).min().orElseThrow();
//         for(int i=0;i<stones.length;i++){
//             stones[i] -= answer;
//         }

//         while(true){
//             for(int i=0;i<stones.length;i++){
//                 if(stones[i]==0){
//                     boolean flag = false;
//                     for(int j=i+1;j<i+k;j++){
//                         if(j>=stones.length){
//                             i=-1;
//                             flag=true;
//                             break;
//                         }
//                         if(stones[j]>0){
//                             flag = true;
//                             i=j;
//                             break;
//                         }
//                     }
//                     if(!flag){
//                         return answer;
//                     }
//                 }
//                 if(i==-1){
//                     break;
//                 }
//                 stones[i]-=1;
//             }
//             answer+=1;
//         }
//     }
// }