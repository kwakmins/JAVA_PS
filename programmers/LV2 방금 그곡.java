import java.util.Arrays;

/**
 * LV2 방금 그곡 https://school.programmers.co.kr/learn/courses/30/lessons/17683
 * 문자열 구현 - 시간만큼 재생한 음악의 악보에 특정 멜로디가 들어가있는지 확인. 같으면 제목 가장 긴 것을 return
 *
 * 시간을 계산하는 메서드로 시간 긴 순으로 정렬 후, 시간만큼 음악의 총 멜로디 추가 후 확인
 * 이 때, A#등은 문자열이 2개라 하나인 다른 수로 변경하는게 편함
 */
class Solution {

  public String solution(String m, String[] musicinfos) {
    String answer = "(None)";
    m = replaceMusic(m);
    String[] arrays = Arrays.stream(musicinfos)
        .map(music -> replaceMusic(music))
        .sorted(
            (a, b) -> -calTime(a.split(",")[0], a.split(",")[1]) + calTime(b.split(",")[0],
                b.split(",")[1])
        ).toArray(String[]::new);

    for (String s : arrays) {
      String[] music = s.split(",");
      int time = calTime(music[0], music[1]);
      String[] mal = music[3].split("");
      String total = "";
      int j = 0;
      for (int i = 0; i < time; i++) {
        if (j == mal.length) {
          j = 0;
        }
        total += mal[j];
        j++;
      }
      if (total.contains(m)) {
        return music[2];
      }
    }

    return answer;
  }

  int calTime(String start, String end) {
    String[] starts = start.split(":");
    String[] ends = end.split(":");

    int startHour = Integer.parseInt(starts[0]);
    int startMin = Integer.parseInt(starts[1]);
    int endHour = Integer.parseInt(ends[0]);
    int endMin = Integer.parseInt(ends[1]);

    startMin += startHour * 60;
    endMin += endHour * 60;

    return endMin - startMin;
  }

  String replaceMusic(String s) {
    return s.replace("C#", "c")
        .replace("D#", "d")
        .replace("F#", "f")
        .replace("G#", "g")
        .replace("A#", "a");
  }
}