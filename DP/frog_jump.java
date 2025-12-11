import java.util.*;

public class frog_jump{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(0);
            sc.close();
            return;
        }
        int[] height = new int[n];
        for(int i = 0; i< n; i++){
            height[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[0] + Math.abs(height[0] - height[1]);
        for(int i = 2; i < n; i++){
            int val1 = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int val2 = dp[i-2] + Math.abs(height[i-2] - height[i]);
            dp[i] = Math.min(val1, val2);
        }        
        System.out.println(dp[n-1]);
        System.out.println(Arrays.toString(dp));
        sc.close();
    }
}
