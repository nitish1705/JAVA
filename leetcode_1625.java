import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1625 {
    private static String adding(int num, int a){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while(num != 0){
            int temp = num % 10;
            int nums = 0;
            if((k+1) % 2 != 0){
                nums = (temp + a) % 10;
            }
            else{
                nums = temp;
            }
            k++;
            num = num / 10;
            sb.insert(0, nums);
        }
        return sb.toString();
    }
    private static String rotate(String num, int b){
        String res = num.substring(num.length() - b, num.length()) + num.substring(0, num.length() - b);
        return res;
    }
    public static String findLexSmallestString(String s, int a, int b) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int maxi = Integer.MAX_VALUE;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
            int p = Integer.parseInt(q.poll());
            maxi = (p < maxi)? p : maxi;
            String res1 = adding(p, a);
            if(!set.contains(res1)){
                set.add(res1);
                q.add(res1);
            }
            String res2 = rotate(res1, b);
            if(!set.contains(res2)){
                set.add(res2);
                q.add(res2);
            }
        }
        return String.valueOf(maxi);
    }
    public static void main(String[] args) {
        
        String s = "5525";
        int a = 9;
        int b = 2;

        String ans = findLexSmallestString(s, a, b);
        System.out.println(ans);
    }
}

// Fixed version with input string 0011 as 0011

// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.Queue;

// public class leetcode_1625 {

//     private static String adding(String num, int a) {
//         char[] arr = num.toCharArray();
//         for (int i = 1; i < arr.length; i += 2) {
//             int digit = (arr[i] - '0' + a) % 10;
//             arr[i] = (char) (digit + '0');
//         }
//         return new String(arr);
//     }

//     private static String rotate(String num, int b) {
//         int n = num.length();
//         return num.substring(n - b) + num.substring(0, n - b);
//     }

//     public static String findLexSmallestString(String s, int a, int b) {
//         HashSet<String> set = new HashSet<>();
//         Queue<String> q = new LinkedList<>();
//         String smallest = s;

//         q.add(s);
//         set.add(s);

//         while (!q.isEmpty()) {
//             String curr = q.poll();
//             if (curr.compareTo(smallest) < 0)
//                 smallest = curr;

//             String res1 = adding(curr, a);
//             String res2 = rotate(curr, b);

//             if (!set.contains(res1)) {
//                 set.add(res1);
//                 q.add(res1);
//             }
//             if (!set.contains(res2)) {
//                 set.add(res2);
//                 q.add(res2);
//             }
//         }
//         return smallest;
//     }

//     public static void main(String[] args) {
//         String s = "5525";
//         int a = 9;
//         int b = 2;

//         String ans = findLexSmallestString(s, a, b);
//         System.out.println(ans); // ✅ Output: 2050
//     }
// }