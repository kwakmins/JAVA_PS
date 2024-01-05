import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * LV2 과제 진행하기 - https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * 구현,큐 - 시간에 맞게 과제를 무조건 시작하고, 하고있던게 있으면 멈춘뒤 시간 남을 때 마다 가장 최근에 멈춘 과제 수행 할 때, 끝나는 과제 순서 구하기
 *
 * 1.시간을 분으로 통일 후, 과제 클래스로 관리.
 * 2.과제 리스트를 시작 시간에 맞게 정렬 및 멈추는 과제는 stack으로 관리
 * 3.다음 과제의 시작시간과 비교하여, (마지막은 그냥 추가)
 *  - 시간이 부족하면 최대 시간 만큼 빼고 stack 추가,
 *  - 남으면 할 수 있는 만큼 멈춘 과제 수행
 *  4.아직 못한 멈춘 과제 마저 수행
 *
 * @!!! 설계할 때, 계산은 좀 더 정확하게 하자
 */
class Solution {

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        List<Subject> list = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            String[] temp = plans[i][1].split(":");
            int start = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            list.add(new Subject(plans[i][0], start, Integer.parseInt(plans[i][2])));
        }
        Collections.sort(list, (o1, o2) -> o1.start - o2.start);

        Stack<Subject> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            Subject s = list.get(i);

            if (i != list.size() - 1) {
                int sTime = s.playTime + s.start;
                int temp = sTime - list.get(i + 1).start;

                if (temp > 0) {
                    s.playTime -= list.get(i + 1).start - s.start;
                    stack.add(s);
                } else {
                    answer.add(s.name);
                    temp = -temp;
                    while (!stack.isEmpty()) {
                        Subject ss = stack.peek();
                        if (temp >= ss.playTime) {
                            temp -= ss.playTime;
                            stack.pop();
                            answer.add(ss.name);
                        } else {
                            ss.playTime -= temp;
                            break;
                        }
                    }
                }
            } else {
                answer.add(s.name);
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.stream().toArray(String[]::new);
    }

    class Subject {

        String name;
        int start, playTime;

        public Subject(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}