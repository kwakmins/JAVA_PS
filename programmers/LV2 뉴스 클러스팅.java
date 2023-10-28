import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LV2 뉴스 클러스팅 https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * Map - 문자열 2개를 2단어씩으로 알파벳이면 쪼개서, 각 집합에 추가 후 공집합과 교집합 구하기(중복 허용)
 *
 * 1. 두개의 map으로 알파벳 검증 및 lowercase 적용하며 map 및 set에 저장.
 * 2. 저장한 set으로 map을 이용하여 합집합 구하기. (중복이면 가장 큰 값 가지기 )
 * 3. 하나의 map으로 교집합 구하기 (중복이면 가장 작은 값 가지기)
 *
 * @!!! 설계를 중간에 하다가 말아서 구현이 조금 꼬였다. 좀 더 설계를 하자
 * @!!! 밑에 주석 참조
 */

class Solution {

  public int solution(String str1, String str2) {
    double answer = 0;
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();
    Set<String> set = new HashSet<>();

    for (int i = 0; i < str1.length() - 1; i++) {
      char a = str1.charAt(i);
      char b = str1.charAt(i + 1);
      if (a >= 'A' && a <= 'Z') {  /** 처음부터 str1에 .lowerCase()하면 문제없음 */
        a -= 'A' - 'a';
      }
      if (b >= 'A' && b <= 'Z') {
        b -= 'A' - 'a';
      }
      if (a >= 'a' && b >= 'a' && a <= 'z' && b <= 'z') { /** Charater.isAlpahbetic(a)를 하면 더 편함*/
        String temp = String.valueOf(a) + String.valueOf(b);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        set.add(temp);
      }
    }

    for (int i = 0; i < str2.length() - 1; i++) {
      char a = str2.charAt(i);
      char b = str2.charAt(i + 1);
      if (a >= 'A' && a <= 'Z') {
        a -= 'A' - 'a';
      }
      if (b >= 'A' && b <= 'Z') {
        b -= 'A' - 'a';
      }
      if (a >= 'a' && b >= 'a' && a <= 'z' && b <= 'z') {
        String temp = String.valueOf(a) + String.valueOf(b);
        map2.put(temp, map2.getOrDefault(temp, 0) + 1);
        set.add(temp);
      }
    }

    int x = 0, y = 0; /** 어차피 65536을 곱하니까 double 필요 없음 */
    for (String s : set) {
      y += Math.max(map.getOrDefault(s, 0), map2.getOrDefault(s, 0));
    }

    for (String s : map.keySet()) {
      if (map2.containsKey(s)) {
        x += Math.min(map.get(s), map2.get(s));
      }
    }

    if (y == 0) {
      return 65536;
    }

    return x * 65536 / y;
  }
}