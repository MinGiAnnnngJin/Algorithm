import java.io.*;
import java.util.*;

class Stack {
    private int size;
    private int topIndex;
    private int[] stackArray;

    public Stack(int size) {
        this.size = size;
        this.topIndex = -1;
        this.stackArray = new int[size];
    }

    public void push(int X) {
        stackArray[++topIndex] = X;
    }

    public int pop() {
        if (empty())
            return -1;
        return stackArray[topIndex--];
    }

    public int top() {
        if (empty())
            return -1;
        return stackArray[topIndex];
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean empty() {
        return topIndex == -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack(10000); // 충분히 큰 스택 생성
        StringBuilder sb = new StringBuilder(); // 출력 최적화

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            switch (command.split(" ")[0]) {
                case "push":
                    int x = Integer.parseInt(command.split(" ")[1]);
                    stack.push(x);
                    break;

                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;

                case "top":
                    sb.append(stack.top()).append("\n");
                    break;

                default:
                    sb.append("Unknown command").append("\n");
                    break;
            }
        }

        // 최종 결과 출력
        System.out.print(sb);
    }
}
