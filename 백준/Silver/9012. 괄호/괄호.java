import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 첫 줄에서 테스트 케이스 개수 읽기
        sc.nextLine(); // 개행 문자 처리 (필수)

        for (int i = 0; i < T; i++) {
            String input = sc.nextLine(); // 각 괄호 문자열 읽기
            System.out.println(isValid(input) ? "YES" : "NO");
        }

        sc.close();
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 여는 괄호를 스택에 추가
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // 스택이 비었는데 닫는 괄호가 나오면 잘못된 문자열
                }
                stack.pop(); // 스택에서 여는 괄호를 제거
            }
        }

        return stack.isEmpty(); // 스택이 비어 있으면 유효한 괄호 문자열
    }
}
