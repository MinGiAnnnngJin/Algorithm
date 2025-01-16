import java.util.*;
import java.util.function.Consumer;

class Solution {
    public int solution(String dartResult) {
       Stack<Integer> stack = new Stack<>();
       Map<Character, Consumer<Stack<Integer>>> actions = new HashMap<>();
        
        //보너스 
        actions.put('S',  
                    s -> stack.push(
                         (int) Math.pow(stack.pop(),1)));
        actions.put('D',
                    s-> stack.push(
                        (int)Math.pow(stack.pop(),2)));
        actions.put('T',
                    s-> stack.push(
                        (int)Math.pow(stack.pop(),3)));
        
        //옵션 
        actions.put('*',s-> 
                    {if (!stack.isEmpty()) {
                            int top = stack.pop()*2; 
                            if(!stack.isEmpty()){
                                int prev = stack.pop()*2;
                                stack.push(prev);
                            }
                            stack.push(top);
                        }  
                    });
            
            actions.put('#',s->stack.push(stack.pop()*-1));
        
        int num = 0;
         boolean isNum = false; // 숫자가 유효한 상태인지 플래그
        for(int i=0; i<dartResult.length();i++){
            char ch = dartResult.charAt(i);
            
            if(Character.isDigit(ch)){
                if(i>0 && Character.isDigit(dartResult.charAt(i-1))){
                    num=num*10+(ch -'0');
                }else{ num=ch-'0';
                     isNum = true; // 숫자가 시작됨 
                     }
                
                }
            
             else {
                  if (isNum) {
                    stack.push(num); // 완성된 숫자를 스택에 추가
                    isNum = false; // 숫자 초기화
                }
              if(actions.containsKey(ch)){
                actions.get(ch).accept(stack);}
                 
            }
                }
           if (isNum) {
            stack.push(num);
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
        }
       public static void main(String[] args) {
    String dartResult = "1S2D*3T";
    Solution sol = new Solution(); // 인스턴스 생성
    System.out.println(sol.solution(dartResult)); // 출력: 37
}

        
    }
