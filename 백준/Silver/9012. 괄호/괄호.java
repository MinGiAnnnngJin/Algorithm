import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 첫 줄에서 테스트 케이스 개수 읽기
        sc.nextLine(); // 개행 문자 처리 (필수)

        // 출력 결과를 저장할 리스트
        List<String> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine(); // 각 괄호 문자열 입력
            // 결과를 리스트에 추가
            results.add(isValid(input) ? "YES" : "NO");
        }

        sc.close();

        // 저장된 결과를 한꺼번에 출력
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
