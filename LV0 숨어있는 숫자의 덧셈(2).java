import java.util.*;
import java.util.stream.*;


class Solution {
  public int solution(String my_string) {
    int answer = 0;
    String temp ="";
    for(char c: my_string.toCharArray()){
      if(c >= '0' &&c<='9'){
        temp+=c;
      } else{
        if(!temp.equals("")){
          answer+=Integer.parseInt(temp);
        }
        temp="";
      }
    }
    if(!temp.equals("")){
      answer+=Integer.parseInt(temp);
    }
    return answer;
  }
}
class Solution2 {
  public int solution(String my_string) {
    int answer = 0;
    String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

    for(String s : str){
      if(!s.equals("")) answer += Integer.valueOf(s);
    }

    return answer;
  }
}
