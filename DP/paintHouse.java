// There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

// For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Return the minimum cost to paint all houses.

// Input Format

// The first line contains an integer n — the number of houses.

// The next n lines contain 3 integers each:

// costs[i][0] → cost to paint house i Red

// costs[i][1] → cost to paint house i Blue

// costs[i][2] → cost to paint house i Green

// Constraints

// costs.length == n costs[i].length == 3 1 <= n <= 100 1 <= costs[i][j] <= 20

// Output Format

// The minimum total cost to paint all houses such that no two adjacent houses have the same color.

// Sample Input 0

// 3
// 17 2 17
// 16 16 5
// 14 3 19
// Sample Output 0

// 10



import java.util.*;

public class paintHouse{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i = 1; i < n; i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
        sc.close();
    }
}
