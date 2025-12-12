
// The Secret Deck of the Time Magician
// Problem
// Submissions
// Leaderboard
// Discussions
// Deep inside an ancient cave, you discover a dusty chest sealed with a glowing riddle. The inscription reads:

// “Only the one who restores the Time Magician’s Secret Deck may enter.”

// Inside the chest, there are sorted cards numbered 1 to N, but the Magician never arranged them in a normal order. He followed a special time-rotation ritual:

// 🕒 The Magician’s Ritual

// 1) We pick up 1 card and put it on the back of the deck.

// 2) Now, we pick up another card, it turns out to be a card numbered 1. We put that card outside the deck.

// 3) If you pick up the wrong card then put it on the back of a deck.

// 4) And, we pick up another card, it turns out to be a card numbered 2. We will put the card outside the deck.

// Repeat the ritual until all cards from 1 to N have been removed in order.

// Your mission:

// 🔮 Can you recreate the deck’s original arrangement before the Magician started his ritual?

// If such an arrangement exists, print the deck from top to bottom.

// If it is impossible to create such a deck for the given value of N, print -1.

// Input Format

// The first line contains an integer T, the number of testcases.

// Each of the next T lines contains a single integer N — the number of cards in the Time Magician’s deck.

// Constraints

// 1 ≤ T ≤ 100 1 ≤ N ≤ 1000

// Output Format

// Print N numbers representing the deck’s original order OR

// Print -1 if no valid arrangement exists.

// Sample Input 0

// 2
// 4
// 5
// Sample Output 0

// 2 1 4 3
// 3 1 4 5 2
// Explanation 0

// Test Case 1: We initially have [2 1 4 3]

// In Step1, we move the first card to the end. Now the deck is: [1 4 3 2]

// In Step2, we get 1. Hence we remove it. Now the deck is: [4 3 2]

// In Step3, we move the 2 front cards only by one to the end ([4 3 2] -> [3 2 4] -> [2 4 3]). Now the deck is: [2 4 3]

// In Step4, we get 2. Hence we remove it. Now the deck is: [4 3]

// In Step5, the following sequence follows: [4 3] -> [3 4] -> [4 3] -> [3 4]. Now the deck is: [3 4]

// In Step6, we get 3. Hence we remove it. Now the deck is: [4]

// Finally, we're left with a single card and thus, we stop.

// Sample Input 1

// 1
// 9
// Sample Output 1

// 7 1 8 6 2 9 4 5 3
import java.util.*;

public class removeListOrder{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            int l = 0;
            for(int i = 1; i <= n; i++){
                    int j = 0;
                while(j < i){
                    if(arr[l] == -1)j++;
                    l++;
                    if(l == n) {l = 0;}
                }
                while(arr[l] != -1){
                    l++;
                    if(l == n) {l = 0;}
                }
                arr[l] = i;
            }
            for(int i = 0 ; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
