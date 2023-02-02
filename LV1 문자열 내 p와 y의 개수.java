class Solution {

  boolean solution(String s) {
    String str = s.toLowerCase();
    return str.chars().filter(c -> c == 'p').count() == str.chars().filter(c -> c == 'y').count();
  }
}

