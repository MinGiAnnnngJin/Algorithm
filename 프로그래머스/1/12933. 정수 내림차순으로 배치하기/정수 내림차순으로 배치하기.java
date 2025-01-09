class Solution{
    public long solution(long n){
        String str = String.valueOf(n);
        int[] num = new int[str.length()];
        for(int i=0;i<num.length;i++)
            num[i]=Character.getNumericValue(str.charAt(i));
        
        for(int i =0; i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if(num[j]<num[j+1]){
                    
                     int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
            StringBuilder strb = new StringBuilder();
            for(int number: num)
                strb.append(number);
            
   return Long.parseLong(strb.toString());
    }
}