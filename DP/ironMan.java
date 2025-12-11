// Tony Stark has discovered an ancient Energy Pyramid hidden beneath one of his abandoned Stark Industries facilities. This pyramid is structured like a triangle, where each cell contains a certain amount of energy value—positive or negative.

// Tony wants to descend from the top of the pyramid to the bottom to stabilize its core. However, his suit’s navigation system has a limitation:

// From any position, Iron Man can only move to one of the two adjacent energy nodes directly below him.

// More formally: If Tony is standing at index i in row r, he may move to index i or i+1 in row r+1.

// Your mission:

// 🟡 Help Iron Man find the path from the top to the bottom of the energy pyramid that results in the minimum total energy cost.

// You are given the entire pyramid as a list of lists, where:

// pyramid[0][0] is the energy at the top

// Each row contains exactly one more element than the previous row

// Values may be positive (energy gain) or negative (energy drain)

// Return the minimum energy Tony must expend while descending from top to bottom.

// Input Format

// First line: integer n — number of rows in the pyramid

// Next n lines: Each line contains the row elements of the pyramid, separated by spaces.

// Constraints

// 1 <= triangle.length <= 200 triangle[0].length == 1 triangle[i].length == triangle[i - 1].length + 1 -104 <= triangle[i][j] <= 104

// Output Format

// Print a single integer: The minimum energy Tony uses to descend from top to bottom.

// Sample Input 0

// 4
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// Sample Output 0

// 11
// Explanation 0

// 2 → 3 → 5 → 1 = 11

// Sample Input 1

// 3
//   1
//  2 3
// 4 5 6
// Sample Output 1

// 7

import java.util.*;

public class ironMan{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                int num = sc.nextInt();
                dp[i][j] = num;
            }
        }
        int k = n-1;
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < k; j++){
                dp[i][j] = dp[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
            k--;
        }
        System.out.println(dp[0][0]);
        sc.close();
    }
}
