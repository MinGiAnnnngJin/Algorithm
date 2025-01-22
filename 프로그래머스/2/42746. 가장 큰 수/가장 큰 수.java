import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(numStrs, (x,y)->(y+x).compareTo(x+y));
        String result= String.join("",numStrs);
        if(result.startsWith("0")){
            return "0";
        }
        return result;
    }
}