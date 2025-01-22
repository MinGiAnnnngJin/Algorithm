import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 수
        int V = sc.nextInt(); // 시작 정점

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }

        // 정점 번호 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(g.get(i));
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        // 결과 출력
        System.out.println(sb.toString());
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int neighbor : g.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for (int neighbor : g.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}
