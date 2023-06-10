class Solution {

  public boolean visit[];
  public int answer = 0;
  public int[][] d;

  public void dfs(int tire, int cnt) {
    for (int i = 0; i < d.length; i++) {
      if (!visit[i] && d[i][0] <= tire) {
        visit[i] = true;
        dfs(tire - d[i][1], cnt + 1);
        visit[i] = false;
      }
    }
    answer = Math.max(answer, cnt);
  }

  public int solution(int k, int[][] dungeons) {
    visit = new boolean[dungeons.length];
    d = dungeons;
    dfs(k, 0);
    return answer;
  }

}