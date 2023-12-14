import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LV3 베스트앨범 - https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 해쉬맵,정렬 - 가장 많이 재생된 장르 중 가장 많이 재생된 음악을 2개씩 선택.
 *
 * 1.해쉬맵으로 가장 많이 재생된 장르 구한 후. 정렬 OR 우선순위 큐에 넣기.
 * 2.정렬된 List를 통해 가장 많이 재생된 음악 2개 고르기.
 *
 * @!!! 한번 더 탐색하면 되는데 굳이 또 MAP으로 해당하는 값 찾으려 했음(오히려 시간 더 많이 듬)
 * @!!! index를 String으로 넣고 split("")로 배열을 만드려 헀으나, 11 -> 1 1 이 되는 현상 발생 (+" " & Split(" ")사용)
 */
class Solution {

  public int[] solution(String[] genres, int[] plays) {
    List<Integer> answer = new ArrayList<>();
    Map<String, Integer> totalMap = new HashMap<>();
    //Map<String, String> map = new HashMap<>();
    PriorityQueue<Music> pq = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);

    for (int i = 0; i < genres.length; i++) {
      totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
      // map.put(genres[i], map.getOrDefault(genres[i], "") + i); Index가 11이면 1 두개가 된다...... 아니면 +" "
    }
    for (String s : totalMap.keySet()) {
      pq.add(new Music(totalMap.get(s), s));
    }

    while (!pq.isEmpty()) {
      String s = pq.poll().name;
      //String[] arr = map.get(s).split("");
      List<Music2> list = new ArrayList<>();
      for (int i = 0; i < genres.length; i++) {
        if (genres[i].equals(s)) {
          list.add(new Music2(i, plays[i]));
        }
      }
      Collections.sort(list, (o1, o2) -> {
        if (o1.sum == o2.sum) {
          return o1.idx - o2.idx;
        } else {
          return o2.sum - o1.sum;
        }
      });

      if (list.size() == 1) {
        answer.add(list.get(0).idx);
      } else {
        for (int i = 0; i < 2; i++) {
          answer.add(list.get(i).idx);
        }
      }
    }
    return answer.stream().mapToInt(i -> i).toArray();
  }

  class Music {

    int cnt;
    String name;

    public Music(int a, String b) {
      cnt = a;
      name = b;
    }
  }

  class Music2 {

    int idx, sum;

    public Music2(int a, int b) {
      idx = a;
      sum = b;
    }
  }
}