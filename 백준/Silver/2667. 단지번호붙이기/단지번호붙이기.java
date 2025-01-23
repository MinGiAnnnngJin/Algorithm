import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   static int N;
   static int[][] map;
   static boolean[][] visited;
   static int[] dx= {-1,1,0,0};
   static int[] dy= {0,0,-1,1};
   static List<Integer> result = new ArrayList<>();

   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       N=sc.nextInt();
       map=new int[N][N];
       visited = new boolean[N][N];


       //지도 만들기
       for(int i=0;i<N;i++) {
           String line = sc.next();
           for(int j =0; j<N;j++){
               map[i][j]=line.charAt(j)-'0';
           }
       }

       //위치 탐색
       for(int i=0; i<N;i++){
           for(int j=0;j<N;j++){
               if(map[i][j]==1 && !visited[i][j]){
                   int size = dfs(i,j);  // 단지 크기 계산
                   result.add(size);
               }
           }
       }

       Collections.sort(result); //단지 크기 오름차순 정렬
       System.out.println(result.size());  //단지 수
       for(int size : result){
           System.out.println(size);  //각 단지 크기
       }
   }
   static int dfs(int x, int y ){
       Stack<int[]> stack = new Stack<>();
       stack.push(new int[]{x,y});
       visited[x][y] = true;
       int count =0;

       while(!stack.isEmpty()){
           int[] current = stack.pop();
           int cx = current[0];
           int cy = current[1];
           count ++;

           //4방향 탐색
           for(int d=0; d<4; d++){
               int nx = cx + dx[d];
               int ny = cy + dy[d];
               if(nx >= 0 && ny >= 0 && nx<N && ny<N ){
                   if(map[nx][ny] ==1 && !visited[nx][ny]){
                       stack.push(new int[] {nx,ny});
                       visited[nx][ny] = true;
                   }
               }
           }
       }
       return count;
   }
}
