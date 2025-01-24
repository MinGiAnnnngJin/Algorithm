import java.util.*;

public class Main {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 행 크기
        m = sc.nextInt(); // 열 크기
        maze = new int[n][m];
        visited = new boolean[n][m];

        // 미로 입력
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자 -> 숫자 변환
            }
        }

        // BFS 수행 및 결과 출력
        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 목표 지점에 도달하면 거리 반환
            if (cx == n - 1 && cy == m - 1) {
                return maze[cx][cy];
            }

            // 인접한 노드 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 범위 내에 있고, 이동 가능하며, 방문하지 않은 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;

                        // 이전 노드의 거리 + 1을 저장
                        maze[nx][ny] = maze[cx][cy] + 1;
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
