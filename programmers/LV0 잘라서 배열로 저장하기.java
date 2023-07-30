import java.util.*;

class Solution {
  public String[] solution(String my_str, int n) {
    List<String> list = new ArrayList<>();
    int x=0;
    while(x+n<my_str.length()){
      list.add(my_str.substring(x,x+n));
      x+=n;
    }
    if(x+n!=my_str.length()-1){
      list.add(my_str.substring(x,my_str.length()));
    }

    return list.stream().toArray(String[]::new);
  }
}