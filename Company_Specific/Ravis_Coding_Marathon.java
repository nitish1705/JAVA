import java.util.*;
public class Ravis_Coding_Marathon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            int skip = dp[i-1][0] + arr[i];
            int work = dp[i-1][1] + (int) (arr[i] / 2);
            dp[i][1] = Math.max(skip, work);
        }
        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
