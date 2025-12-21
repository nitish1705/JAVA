import java.util.*;

public class leetcode_955{
	public static int minDeletionSize(String[] strs) {
        int count = 0;
		int r = strs.length;
		int c = strs[0].length();
		String[] arr1 = new String[r];
		Arrays.fill(arr1, "");
		for(int i = 0; i < c; i++){
			int flag = 0;
			for(int j = 1; j < r; j++){
				String s1 = arr1[j-1] + strs[j-1].charAt(i);
				String s2 = arr1[j] + strs[j].charAt(i);
				if(s1.compareTo(s2) > 0){
					flag = 1;
					count++;
					break;
				}
			}
			if(flag == 0){
				for(int k = 0; k < r; k++){
					arr1[k] = arr1[k] + strs[k].charAt(i);
				}
			}
			System.out.println(Arrays.toString(arr1));
		}
		return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res = minDeletionSize(new String[] {"xga", "xfb", "yfa"});
		System.out.println(res);
        sc.close();
    }
}
