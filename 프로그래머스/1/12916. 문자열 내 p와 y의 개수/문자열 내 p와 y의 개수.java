class Solution {
    boolean solution(String s) {
         boolean answer = true;
        String[] str = s.split("");
        int pnum=0;
        int ynum=0;
        for(int i=0; i<str.length;i++){
            if(str[i].equalsIgnoreCase("p"))
                pnum+=1;
            else if (str[i].equalsIgnoreCase("y"))
                ynum+=1;
        }
        if(pnum==ynum)
         return   answer = true;
        else  return answer =false;
       
    }
}