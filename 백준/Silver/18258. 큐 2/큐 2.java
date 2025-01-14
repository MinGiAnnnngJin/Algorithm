import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>(); // 큐 구현

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                queue.add(x);
            } else if (command.equals("pop")) {
                bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
            } else if (command.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write((queue.isEmpty() ? 1 : 0) + "\n");
            } else if (command.equals("front")) {
                bw.write((queue.isEmpty() ? -1 : queue.peek()) + "\n");
            } else if (command.equals("back")) {
                bw.write((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
