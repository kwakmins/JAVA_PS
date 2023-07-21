class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                int temp=s.charAt(i)+n;
                if(temp>'z'){
                    temp='a'+(temp)-'z'-1;
                } else if(temp>'Z' && temp-n<'a'){
                    temp='A'+(temp)-'Z'-1;
                }
                answer.append((char)(temp));
            }else{
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}