class Solution {
  public int solution(String myString, String pat) {
    int answer=0;
    char[] myStrings = myString.toCharArray();
    for(int i=0;i<myStrings.length-pat.length()+1;i++){
      if(myStrings[i] == pat.charAt(0)){
        Boolean b = false;
        for(int j=1;j<pat.length();j++){
          if(myStrings[i+j] != pat.charAt(j)){
            b = true;
            break;
          }
        }
        if(!b){
          answer++;
        }
      }
    }
    return answer;
  }
}