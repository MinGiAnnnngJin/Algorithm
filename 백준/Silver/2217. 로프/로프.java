import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     Integer[] ropes = new Integer[n];
     for(int i=0;i<n;i++){
         ropes[i] = sc.nextInt();
     }
     Arrays.sort(ropes, Collections.reverseOrder());
     int count = 1;
     int maxweight = 0;
     for(int i =0;i<n;i++){
         if(maxweight < ropes[i] * count)
             maxweight = ropes[i] * count;
         count ++;
     }
    System.out.println(maxweight);
    }}

