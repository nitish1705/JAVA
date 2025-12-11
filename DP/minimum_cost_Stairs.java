import java.util.*;

public class minimum_cost_Stairs{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        for(int i = 0; i < n; i++){
            cost[i] = sc.nextInt();
        }
        int[] dp = new int[n+2];
        dp[n] = 0;
        dp[n+1] = 0;
        for(int i = n-1; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        System.out.println(Math.min(dp[0], dp[1]));
        sc.close();
    }
}
