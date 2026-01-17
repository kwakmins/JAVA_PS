class Solution {

    int[] numbers;
    int target;
    int result=0;

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;

        dfs(0,0);

        return result;
    }

    public void dfs(int depth,int sum){

        if(depth==numbers.length){

            if(sum==target){
                result++;
            }
            return;
        }

        //dfs(depth+1, sum+=numbers[depth]);
        //dfs(depth+1, sum-=numbers[depth]);
        dfs(depth+1, sum+numbers[depth]);
        dfs(depth+1, sum-numbers[depth]);

    }
}