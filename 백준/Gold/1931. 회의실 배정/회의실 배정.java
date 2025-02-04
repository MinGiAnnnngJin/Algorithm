import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine()); //회의 수

      int[][] m= new int[n][2]; //회의 정보 배열
      for(int i=0;i<n;i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          m[i][0] = Integer.parseInt(st.nextToken()); //시작
          m[i][1]= Integer.parseInt(st.nextToken());  //끝
      }

      Arrays.sort(m, (a,b) -> {
                  if (a[1] == b[1])
                      return a[0] - b[0];  //양수면 뒤로 음수면 앞으로
                  return a[1] - b[1];
              });

      int count =0;
      int endTime=0;

      for(int i=0;i<n;i++){
          if(m[i][0]>=endTime){
              count ++;
              endTime = m[i][1];
          }
      }
      System.out.println(count);
    }

    }

