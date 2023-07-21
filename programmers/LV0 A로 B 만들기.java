class Solution {
  public int solution(String before, String after) {
    for(String s: before.split("")){
      if(after.indexOf(s)!=-1){
        after = after.replaceFirst(s,"");
      } else{
        return 0;
      }
    }
    return 1;
  }
}