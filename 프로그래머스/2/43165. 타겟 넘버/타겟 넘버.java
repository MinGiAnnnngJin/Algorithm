class Solution {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target);
        return answer;
    }
    private void dfs(int[] numbers, int idx, int sum, int target){       // 모든 숫자를 다 사용한 경우
        if(idx == numbers.length){
            if(sum == target)
                answer ++ ;
            return;
        }
        dfs(numbers,idx+1,sum+numbers[idx],target);
        dfs(numbers,idx+1,sum-numbers[idx],target);
    }
}

