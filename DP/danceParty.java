// At a school party, p students want to join a fun dance activity. Each student can either dance alone or dance in a pair with one other student. No student can be in more than one pair.

// How many different ways can the p students join the dance?

// Input Format

// A single integer p — the number of students at the party.

// Constraints

// 1≤p≤30 Each student can either: dance alone, or form a pair with exactly one other student No student can appear in more than one pair.

// Output Format

// A single integer — the number of different ways the students can join the dance (each dancing alone or in pairs)

// Sample Input 0

// 3
// Sample Output 0

// 4
// Explanation 0

// Three people → All alone Pair (1,2) + 3 alone Pair (1,3) + 2 alone Pair (2,3) + 1 alone

// Sample Input 1

// 2
// Sample Output 1

// 2
// Sample Input 2

// 5
// Sample Output 2

// 26
import java.util.*;

public class danceParty{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + i-1 * dp[i-2];
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
