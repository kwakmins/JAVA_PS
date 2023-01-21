import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String[] seoul) {
        List<String> arrayList=Arrays.asList(seoul);
        int index=arrayList.indexOf("Kim");
        return "김서방은 "+index+"에 있다";
    }
}