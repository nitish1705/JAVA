import java.util.*;
public class elevator {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] nums = new int[n][3];
		int len = 0;
		int sums = 0;
		int curr = 0;
		for(int i = 0; i < n; i++){
		    nums[i][0] = sc.nextInt();
		    sums += nums[i][0];
		    if(sums > curr){
		        nums[i][1] = curr+1;
		        nums[i][2] = sums;
		        curr = nums[i][2];
		    }
		    else if(sums < curr){
		        nums[i][1] = sums;
		        nums[i][2] = curr-1;
		        curr = nums[i][1];
		    }
		    len = Math.max(len, sums);
		}
        for(int i = len; i > 0; i--){
            for(int j = 0; j < n; j++){
                if(i >= nums[j][1] && i <= nums[j][2]){
                    System.out.print("*");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
	}
}