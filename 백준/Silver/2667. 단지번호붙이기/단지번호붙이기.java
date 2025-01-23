import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n; //지도 크기
    static int[][] map; //지도 정보
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 지도 크기
        map = new int[n][n];
        visited = new boolean[n][n];

        //지도 내용물 입력 받기, sc.next는 한줄로 입력받아짐
        for (int i = 0; i < n; i++) {
            String line = sc. next();
            for (int j = 0; j < n; j++) {
                map[i][j] =line.charAt(j)-'0';
            }
        }

        // 지도 탐색
        for(int i= 0; i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    int size = dfs(i,j);  //단지 크기
                    result.add(size);
                }
            }
        }

        //리스트 정렬
        Collections.sort(result);
        //단지수 출력
        System.out.println(result.size());
        for(int i =0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    static int dfs(int x, int y){
       Stack<int[]> stack = new Stack<>();
       stack.add(new int[] {x,y});
       visited[x][y]=true;
       int count = 0;

       while(!stack.isEmpty()){
           int [] current = stack.pop(); //현재 정점의 x,y값
           int cx = current[0];
           int cy = current[1];
           count ++;

           //현재 정점 주변 방문
           for(int d =0; d < 4; d++){
               int nx = cx + dx[d];
               int ny = cy + dy[d];

               if(nx>=0 && ny>=0 && nx<n && ny<n ){  // 범위 체크
                   if(map[nx][ny]==1 &&!visited[nx][ny]){
                       stack.push(new int[] {nx,ny});
                       visited[nx][ny]=true;
                   }
               }

           }
              }
        return count;
    }
}
