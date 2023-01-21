import java.util.*;

class Solution {
    public int solution(int num) {
        Set<Integer> set = new HashSet<>();
        if (num == 1) {
            return 0;
        }
        for (int i = 1; i <= 500; i++) {
            if (set.contains(num)) {
                break;
            } else {
                set.add(num);
            }
            if (num % 2 == 1) {
                num = num * 3 + 1;
            } else {
                num /= 2;
            }
            if (num == 1) {
                return i;
            }
        }
        return -1;
    }
}