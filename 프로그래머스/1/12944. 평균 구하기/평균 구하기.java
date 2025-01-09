class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double b=0;
        for(int i = 0; i<arr.length;i++)
            b+=arr[i];
        answer=b/arr.length;
        return answer;
    }
}