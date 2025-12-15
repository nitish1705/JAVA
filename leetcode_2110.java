import java.util.*;

public class leetcode_2110{
    public static long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long count = 0; 
        int left = 0;
        int right = 1;
        long subCount = 1;
        while(right < n){
            if(prices[left] - prices[right] == 1){
                subCount++;
                left++;
                right++;
                continue;
            }
            else{
                if(subCount > 1){
                    count += (subCount*(subCount+1)) / 2;
                }
                else{
                    count++;
                }
                left = right;
                subCount = 1;
            }
            right++;
        }
        if(left != right){
            if(subCount == 1) count++;
            else{
                count += (subCount*(subCount+1)) / 2;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long val = getDescentPeriods(new int[] {12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7});
        System.out.println(val);
        sc.close();
    }
}
