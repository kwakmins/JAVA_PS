class Solution {

    int answer = Integer.MIN_VALUE;
    boolean visit[];
    int len;
    int[][] dungeons;

    public int solution(int k, int[][] dungeons) {

        len = dungeons.length;
        visit = new boolean[len];
        this.dungeons = dungeons;

        func(k, 0);

        return answer;
    }

    // 순열 - 순서가 다르면 다른값
    void func(int value, int cnt) {

        answer = Math.max(answer, cnt);

        for (int i = 0; i < len; i++) {
            if (!visit[i] && value >= dungeons[i][0]) {

                visit[i] = true;
                func(value - dungeons[i][1], cnt + 1);
                visit[i] = false;
            }
        }
    }

    // 조합 - 순서가 달라도 같은 값
//    void func(int value,int cnt, int idx) {
//
//        answer= Math.max(answer,cnt);
//        if(idx>=len) return;
//
//        if(value >= dungeons[idx][0]){
//            func(value-dungeons[idx][1],cnt+1,idx+1);
//        }
//        func(value,cnt,idx+1);
//    }
}