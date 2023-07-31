import java.math.BigInteger;

class Solution {

  public int solution(int balls, int share) {
    return (pacto(balls).divide(pacto(balls - share).multiply(pacto(share)))).intValue();
  }

  public BigInteger pacto(int x) {
    BigInteger answer = new BigInteger("1");
    for (long i = 2; i <= x; i++) {
      answer = answer.multiply(new BigInteger(String.valueOf(i)));
    }
    return answer;
  }
}

