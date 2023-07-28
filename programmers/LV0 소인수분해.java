import java.util.*;
import java.util.stream.*;

class Solution {
  public int[] solution(int n) {
    List<Integer> list = new ArrayList<>();
    int x = 2;

    while(n!=1){
      if(n % x ==0){
        n/=x;
        list.add(n);
      } else{
        x++;
      }
    }
    return list.stream().mapToInt(i->i).distinct().toArray();
  }
}