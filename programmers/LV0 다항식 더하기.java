class Solution {

  public String solution(String polynomial) {
    String answer = "";
    String[] str = polynomial.split(" \\+ ");

    int x = 0;
    int sum = 0;

    for (int i = 0; i < str.length; i++) {
      if (str[i].contains("x")) {
        if (str[i].equals("x")) {
          x += 1;
        } else {
          x += Integer.parseInt(str[i].substring(0, str[i].length() - 1));
        }
      } else if (!str[i].equals("+")) {
        sum += Integer.parseInt(str[i]);
      }
    }

    if (sum == 0 && x != 0) {
      if (x == 1) {
        answer = "x";
      } else {
        answer = x + "x";
      }
    }

    if (x == 0 && sum != 0) {
      answer = String.valueOf(sum);
    }

    if (x != 0 && sum != 0) {
      if (x == 1) {
        answer = "x + " + sum;
      } else {
        answer = x + "x + " + sum;
      }
    }

    return answer;
  }
}

