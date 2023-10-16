import java.math.BigInteger;

/**
 * LV2 숫자카드 나누기 https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * 주어진 두 배열에 한 배열의 공약수가 다른 배열의 약수가 아닌 수 중 가장 큰 수
 *
 * @Param 두 배열
 * @Return 가장 큰 수
 *
 * 한 배열의 최대 공약수를 구하여, 다른 쪽 배열의 원소 중 약수에 포함되면 0, 안되면 최대공약수 return
 * 반대쪽도 동일하게 실행한뒤, 큰 수 비교.
 * ---
 * @!!! 공약수가 한 원소의 약수에 포함되면, 공약수의 약수들도 포함 (최대 공약수만 보면됨)
 * @!!! BigInteger은 java.math.*;
 */
class Solution {

  public int solution(int[] arrayA, int[] arrayB) {
    int answer = 0;
    answer = Math.max(cal(arrayA, arrayB), cal(arrayB, arrayA));
    return answer;
  }

  int cal(int[] arrayA, int[] arrayB) {
    int aGcd = getGcd(arrayA);
    for (int i : arrayB) {
      if (i % aGcd == 0) {
        return 0;
      }
    }
    return aGcd;
  }

  int getGcd(int[] array) {
    BigInteger a = BigInteger.valueOf(array[0]);
    for (int i = 1; i < array.length; i++) {
      BigInteger b = BigInteger.valueOf(array[i]);
      a = a.gcd(b);
    }
    return a.intValue();
  }
}