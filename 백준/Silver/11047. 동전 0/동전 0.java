import java.util.*;

public class Main {
    public static void main(String[] args){
        int a=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //동전 종류수
        int k = sc.nextInt();  //얼마임
        int[] coins = new int[n];
        for(int i =0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        for(int i=n-1;i>=0;i--){
            if(k>=coins[i]){
               a += k/ coins[i];  //동전이 몇개 필요한지
                k=k%coins[i]; // 남은거
            }
        }
        System.out.println(a);

    }

    }
