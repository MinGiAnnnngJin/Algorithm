import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Stack<Character> stack = new Stack<>();
        int removeCount = 0;
        for(int i=0;i<n;i++) {
            char current = number.charAt(i);
            while(!stack.isEmpty() && removeCount<k &&stack.peek()<current){
                stack.pop();
                removeCount++;
            }
            stack.push(current);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-k;i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);

    }
}
