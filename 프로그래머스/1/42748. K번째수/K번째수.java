import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for(int i = 0; i<commands.length;i++){
            int s= commands[i][0] - 1;
            int e = commands[i][1];
            int k = commands[i][2]-1;
            
            int[] n = Arrays.copyOfRange(array, s,e);
            Arrays.sort(n);
            
            result[i]=n[k];
        }
        
        return result;
    }
    }
