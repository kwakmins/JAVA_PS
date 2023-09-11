import java.util.*;

class Solution {
  public int solution(String skill, String[] skill_trees) {
    int answer = 0;

    for(String skill_tree : skill_trees){
      Queue<String> q = new LinkedList<>();
      for(String s : skill.split("")){
        q.add(s);
      }
      boolean flag = true;
      for(String s : skill_tree.split("")){
        if(!q.isEmpty()&&q.peek().equals(s)){
          q.poll();
        } else if(!q.isEmpty() && q.contains(s)){
          flag = false;
          break;
        }
      }
      if(flag){
        answer++;
      }
    }
    return answer;
  }
}